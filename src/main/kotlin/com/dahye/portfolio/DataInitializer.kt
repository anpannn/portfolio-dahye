package com.dahye.portfolio

import com.dahye.portfolio.domain.constant.SkillType
import com.dahye.portfolio.domain.entity.*
import com.dahye.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {
    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")
        // achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "ㅇㅇ",
                description = "ㅇㅇ",
                host = "ㅇㅇ",
                achievedDate = LocalDate.of(2024, 12, 12),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2024, 12, 12),
                isActive = true
            ),
        )
        achievementRepository.saveAll(achievements)
        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "ㅇㅇ", isActive = true),
            Introduction(content = "ㅇㅇ", isActive = true),
            Introduction(content = "ㅇㅇ", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/anpannn", isActive = true),
            Link(name = "Linkedin", content = "https://github.com/anpannn", isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
            title = "dd(dd.)",
            description = "컴퓨터공학 전공",
            startYear = 2021,
            startMonth = 3,
            endYear = 2025,
            endMonth = 2,
            isActive = true,
        )

        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "dd", isActive = true),
                ExperienceDetail(content = "ㅇㅇ", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "ㅇㅇ(dd.)",
            description = "ㅇㅇ",
            startYear = 2024,
            startMonth = 12,
            endYear = null,
            endMonth = null,
            isActive = true,
        )

        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "ㅇㅇ", isActive = true),
                ExperienceDetail(content = "ㅇㅇ", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka))

        // project / project_detail / project_skill 초기화
        val project1 = Project(
            name = "ㅇㅇ",
            description = "ㅇㅇ.",
            startYear = 2024,
            startMonth = 12,
            endYear = 2024,
            endMonth = 12,
            isActive = true
        )

        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "ㅇㅇ", url = null, isActive = true),
                ProjectDetail(content = "ㅇㅇ", url = null, isActive = true)
            )
        )

        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis)
            )
        )

        val project2 = Project(
            name = "ㅇㅇ",
            description = "ㅇㅇ.",
            startYear = 2024,
            startMonth = 12,
            endYear = null,
            endMonth = null,
            isActive = true
        )

        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "ㅇㅇ", url = null, isActive = true),
                ProjectDetail(content = "ㅇㅇ", url = null, isActive = true),

                )

        )

        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = django),
                ProjectSkill(project = project2, skill = kafka)
            )
        )

        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$DurnpvExLU.9bxTz22XNw.I6FKDhWoXHMhWiifQWEWtySOkSbnmH6"
        )
        accountRepository.save(account)
    }

}