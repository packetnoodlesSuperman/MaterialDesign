package com.bob.framework.base;

import android.content.Context;
import io.reactivex.Observable;
import androidx.lifecycle.MutableLiveData;
import com.fqxyi.network.RequestManager;
import com.fqxyi.network.bean.ErrorBean;
import com.fqxyi.network.callback.IResponseCallback;
import com.fqxyi.network.tag.ReqTag;

public abstract class BaseRepository<T> {

    protected Context context;

    protected final MutableLiveData<T> liveData;

    public BaseRepository(Context context) {
        this.context = context;
        liveData = new MutableLiveData<>();
    }

    public void loadData() {
        RequestManager.get().async(
                getReqTag(),
                getApiService(),
            new IResponseCallback<T>() {
                @Override
                public void onSuccess(ReqTag reqTag, T response) {
                    responseSuccess(reqTag, response);
                }

                @Override

                public void onError(ReqTag reqTag, ErrorBean errorBean) {
                    responseError(reqTag, errorBean);
                }
            }
        );
    }

    /**
     * 获取数据
     */
    public MutableLiveData<T> getData() {
        return liveData;
    }

    protected ReqTag getReqTag() {
        return null;
    }

    public abstract Observable<T> getApiService();

    public abstract void responseSuccess(ReqTag reqTag, T response);

    public abstract void responseError(ReqTag reqTag, ErrorBean errorBean);

}
