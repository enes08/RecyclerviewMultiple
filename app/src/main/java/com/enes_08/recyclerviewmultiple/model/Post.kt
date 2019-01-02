package com.enes_08.recyclerviewmultiple.model

class Post {

    private var user: User? = null

    private var title: String? = null
    private var description: String? = null
    private var image: Int? = null
    private var date: String? = null
    private var likeCount: String? = null
    private var type: Type? = null


    var mTitle: String
        get() = this.title!!
        set(value) {
            this.title = value
        }

    var mUser: User
        get() = this.user!!
        set(value) {
            this.user = value
        }

    var mDescription: String
        get() = this.description!!
        set(value) {
            this.description = value
        }


    var mDate: String
        get() = this.date!!
        set(value) {
            this.date = value
        }


    var mImage: Int
        get() = this.image!!
        set(value) {
            this.image = value
        }


    var mLikeCount: String
        get() = this.likeCount!!
        set(value) {
            this.likeCount = value
        }

    var mType: Type
        get() = this.type!!
        set(value) {
            this.type = value
        }


    constructor(
        user: User, title: String, description: String,
        date: String, likeCount: String
    ) {
        this.user = user
        this.title = title
        this.description = description
        this.date = date
        this.likeCount = likeCount
        this.type = Type.TEXT


    }

    constructor(
        user: User, title: String, description: String
        , image: Int, date: String, likeCount: String
    ) {

        this.user = user
        this.title = title
        this.description = description
        this.date = date
        this.likeCount = likeCount
        this.type = Type.MULTİPLE
        this.image = image


    }

    constructor(
        user: User, title: String, image: Int, date: String, likeCount: String
    ) {

        this.user = user
        this.date = date
        this.title = title
        this.likeCount = likeCount
        this.type = Type.IMAGE
        this.image = image
    }


    enum class Type {
        TEXT, IMAGE, MULTİPLE

    }


}