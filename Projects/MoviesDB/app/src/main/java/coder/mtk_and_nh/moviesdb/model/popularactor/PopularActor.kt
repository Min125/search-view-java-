package coder.mtk_and_nh.moviesdb.model.popularactor

data class PopularActor(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)