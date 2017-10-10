package com.xm.study.components.view;

import com.xm.study.base.IView;

/**
 * @author: xm on 2017/10/9.
 * @describe:
 */

public interface IComponentsView extends IView {

    void byBinderInitDone();

    void byBinderDonwloadDone();

    void byBinderShowProgress(int progress);

    void byInterfaceInitDone();

    void byInterfaceDonwloadDone();

    void byInterfaceShowProgress(int progress);

    void unbindDone();
}
