package com.mithuroy.expoyapplication

data class SimpleModel(val type: String, val content: String)

fun getSimpleData() = mutableListOf(
        SimpleModel("Header", "Category1"),
        SimpleModel("Content", "Lorem-Ipsum"),
        SimpleModel("Content", "Lorem-dasd"),
        SimpleModel("Content", "Lorem-dmbsajcb"),
        SimpleModel("Header", "Category2"),
        SimpleModel("Content", "Lorem-fdsjdf"),
        SimpleModel("Content", "Lorem-dmfd"),
        SimpleModel("Content", "Lorem-mdabjds"),
        SimpleModel("Header", "Category3"),
        SimpleModel("Content", "Lorem-dfbjdf"),
        SimpleModel("Content", "Lorem-dfbjd"),
        SimpleModel("Content", "Lorem-kfdbjdf"),
        SimpleModel("Header", "Category4"),
        SimpleModel("Content", "Lorem-fmbsdf"),
        SimpleModel("Content", "Lorem-fbfjd"),
        SimpleModel("Footer", "End of list")
)