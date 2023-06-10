package ru.kiruxadance.feature_car_details.data.mapper

import ru.kiruxadance.core.network.model.*
import ru.kiruxadance.feature_car_details.domain.model.*

fun CarDetailsResponse.toDomainCarDetails(): CarDetails {
    return CarDetails(
        car = this.car.toDomainCar(),
        user = this.user.toUserDetailsDomain()
    )
}

fun CarDetailsDto.toDomainCar(): Car {
    return Car(
        id = this.id,
        images = this.images.toDomainImages(),
        name = this.name,
        year = this.year,
        follow = this.follow,
        followers_count = this.followers_count
    )
}

fun List<ImageDto>.toDomainImages(): List<Image> {
    return this.map {
        Image(
            id = it.id,
            image100 = it.image100,
            image500 = it.image500,
            index = it.index,
            is_primary = it.is_primary,
            size = it.size,
            thumbnail_url = it.thumbnail_url,
            url = it.url,
        )
    }
}

fun UserDto.toUserDomain(): User {
    return User(
        auto_count = this.auto_count,
        avatar = this.avatar.toAvatarDomain(),
        id = this.id,
        main_auto_name = this.main_auto_name,
        username = this.username
    )
}

fun AvatarDto.toAvatarDomain(): Avatar {
    return Avatar(
        path = this.path,
        url = this.url
    )
}

fun CarsPostsResponse.toDomainCarPosts(): CarPosts {
    return CarPosts(
        posts = this.posts.toDomainPosts(),
        user = this.user.toUserDomain()
    )
}

fun List<PostDto>.toDomainPosts(): List<Post> {
    return this.map {
        Post(
            author = it.author.toUserDomain(),
            comment_count = it.comment_count,
            created_at = it.created_at,
            id = it.id,
            img = it.img,
            like_count = it.like_count,
            text = it.text
        )
    }
}

fun UserDetailsDto.toUserDetailsDomain(): UserDetails {
    return UserDetails(
        about = this.about,
        auto_count = this.auto_count,
        avatar = this.avatar.toAvatarDomain(),
        email = this.email,
        id = this.id,
        main_auto_name = this.main_auto_name,
        username = this.username
    )
}
