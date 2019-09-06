package com.bob.framework.repository;

import android.content.Context;
import com.bob.framework.base.BaseRepository;
import com.bob.framework.bean.MainBean;
import com.fqxyi.network.bean.ErrorBean;
import com.fqxyi.network.tag.ReqTag;
import io.reactivex.Observable;

public class MainRepository extends BaseRepository<MainBean> {
    public MainRepository(Context context) {
        super(context);
    }

    @Override
    public Observable<MainBean> getApiService() {
        return null;
    }

    @Override
    public void responseSuccess(ReqTag reqTag, MainBean response) {

    }

    @Override
    public void responseError(ReqTag reqTag, ErrorBean errorBean) {

    }
}
