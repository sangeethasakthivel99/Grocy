package com.sangeetha.grocy.home.data.dto

import com.sangeetha.grocy.home.domain.model.Banners

data class BannersDto(
    val bannerImage: String = ""
) {
    companion object Factory {
        fun create() :BannersDto = BannersDto()
    }
}

fun BannersDto.toBanners(): Banners {
    return Banners(
        this.bannerImage
    )
}


