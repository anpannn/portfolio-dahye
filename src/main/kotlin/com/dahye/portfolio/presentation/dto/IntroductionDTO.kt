package com.dahye.portfolio.presentation.dto

import com.dahye.portfolio.domain.entity.Introduction

class IntroductionDTO(val content: String) {

    constructor(introduction: Introduction) : this(content = introduction.content)
}