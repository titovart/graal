package com.github.titovart.graal.aggregation.client

import com.github.titovart.graal.aggregation.entity.post.PostFeignRequest
import com.github.titovart.graal.aggregation.entity.post.PostFeignResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.hateoas.PagedResources
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(name = "post-service", configuration = arrayOf(FeignClientContext::class))
interface PostClient {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/posts/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<PostFeignResponse>

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/posts/find")
    fun getByUserId(@RequestParam("user_id") userId: Long,
                    @RequestParam("page") page: Int = 0,
                    @RequestParam("size") size: Int = 20): PagedResources<PostFeignResponse>


    @RequestMapping(method = arrayOf(RequestMethod.PUT), value = "/posts/{id}")
    fun update(@PathVariable("id") id: Long, postRequest: PostFeignRequest): ResponseEntity<Unit>

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = "/posts")
    fun create(postRequest: PostFeignRequest): ResponseEntity<Unit>
}