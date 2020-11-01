package com.quorum.demo.network;


import androidx.annotation.NonNull;
import com.quorum.demo.common.Result;
import lombok.AllArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AllArgsConstructor
public final class ApiResponseCallback<T> implements Callback<T>
{

    private final Result<T> callback;

    @Override
    public void onResponse(final @NonNull Call<T> call, final @NonNull Response<T> response)
    {
        callback.success(response.body());
    }

    @Override
    public void onFailure(final @NonNull Call<T> call, final @NonNull Throwable t)
    {
        callback.failed(t.getMessage());
    }
}
