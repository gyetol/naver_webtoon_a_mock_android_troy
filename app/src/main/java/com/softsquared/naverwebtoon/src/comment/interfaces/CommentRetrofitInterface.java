package com.softsquared.naverwebtoon.src.comment.interfaces;

        import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
        import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
        import com.softsquared.naverwebtoon.src.comment.models.CommentResponse;
        import com.softsquared.naverwebtoon.src.comment.models.RequestCommentAdd;
        import com.softsquared.naverwebtoon.src.comment.models.RequestCommentState;

        import okhttp3.RequestBody;
        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;
        import retrofit2.http.Query;

public interface CommentRetrofitInterface {
    @GET("/episodes/{episodeIdx}/comments")
    Call<CommentResponse> getComment(
            @Path("episodeIdx") int episodeIdx,
            @Query("keyword") final String keyword
    );

    @POST("/comments/{commentIdx}/state")
    Call<CommentLikeResponse> getCommentLike(
            @Path("commentIdx") int commentIdx,
            @Body RequestCommentState params
    );
    @POST("/episodes/{episodeIdx}/comments")
    Call<CommentAddResponse> getCommentAdd(
            @Path("episodeIdx") int episodeIdx,
            @Body RequestCommentAdd params
    );

}
