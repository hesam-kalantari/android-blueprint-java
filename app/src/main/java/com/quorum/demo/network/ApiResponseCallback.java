package com.quorum.demo.network;


import androidx.annotation.NonNull;
import com.quorum.demo.common.ModelMapper;
import com.quorum.demo.common.Result;
import lombok.AllArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AllArgsConstructor
public final class ApiResponseCallback<M, D> implements Callback<M>
{

    private final Result<D> callback;
    private final ModelMapper<M, D> mapper;


    @Override
    public void onResponse(final @NonNull Call<M> call, final @NonNull Response<M> response)
    {
        callback.success(mapper.mapFromModel(response.body()));
    }

    @Override
    public void onFailure(final @NonNull Call<M> call, final @NonNull Throwable t)
    {
        callback.failed(t.getMessage());
    }
}
