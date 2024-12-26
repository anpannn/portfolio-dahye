package com.dahye.portfolio.admin.context.project.controller

import com.dahye.portfolio.admin.context.project.form.ProjectSkillForm
import com.dahye.portfolio.admin.context.project.service.AdminProjectSkillService
import com.dahye.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSkillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {

    @PostMapping
    fun postProjectSkill(@RequestBody form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable("id") id: Long): ResponseEntity<Any> {
        adminProjectSkillService.delete(id)

        return ApiResponse.successDelete()
    }
}