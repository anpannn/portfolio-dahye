package com.dahye.portfolio.presentation.dto

import com.dahye.portfolio.domain.entity.Achievement
import com.dahye.portfolio.domain.entity.Experience
import com.dahye.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

class ResumeDTO(
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills: List<Skill>
) {
    var experiences: List<ExperienceDTO> = experiences.map { experience ->
        ExperienceDTO(
            title = experience.title,
            description = experience.description,
            startYearMonth = "${experience.startYear}.${experience.startMonth}",
            endYearMonth = experience.getEndYearMonth(),
            details = experience.details.filter { it.isActive }.map { it.content }
        )
    }

    var achievements: List<AchievementDTO> = achievements.map { achievement ->
        AchievementDTO(
            title = achievement.title,
            description = achievement.description,
            host = achievement.host,
            achievedDate = achievement.achievedDate
                ?.format(DateTimeFormatter.ISO_LOCAL_DATE)
                ?.replace("-", ".")
        )
    }
    var skills: List<SkillDTO> = skills.map { skill -> SkillDTO(skill) }

}


