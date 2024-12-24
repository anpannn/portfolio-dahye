package com.dahye.portfolio.presentation.dto

import com.dahye.portfolio.domain.entity.Skill

class SkillDTO(val name: String, val type: String) {

    constructor(skill: Skill) : this(name = skill.name, type = skill.type.name)
}