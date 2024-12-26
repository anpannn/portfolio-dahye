package com.dahye.portfolio.admin.context.link.service

import com.dahye.portfolio.admin.data.TableDTO
import com.dahye.portfolio.domain.entity.Link
import com.dahye.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(private val linkRepository: LinkRepository) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}