package com.xm.study.easechat.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.xm.study.base.BaseActivity;
import com.xm.study.R;
import com.xm.study.easechat.chat.ECChatActivity;
import com.xm.study.easechat.login.ECLoginActivity;
import com.xm.study.easechat.main.presenter.ECMainPresenterCompl;
import com.xm.study.easechat.main.presenter.IECMainPresenter;
import com.xm.study.easechat.main.view.IECMainView;

public class ECMainActivity extends BaseActivity implements IECMainView {

    private final String TAG = this.getClass().getSimpleName();
    private IECMainPresenter mIECMainPresenter;

    private EditText mEditChatId;
    private Button mBtnStartChat;
    private Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 判断sdk是否登录成功过，并没有退出和被踢，否则跳转到登陆界面
        if (!EMClient.getInstance().isLoggedInBefore()) {
            Intent intent = new Intent(ECMainActivity.this, ECLoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_ecmain);

        //init
        mIECMainPresenter = new ECMainPresenterCompl(this, this);

        initView();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    /**
     * 初始化界面
     */
    private void initView() {

        mEditChatId = (EditText) findViewById(R.id.et_chat_id);

        mBtnStartChat = (Button) findViewById(R.id.btn_start_chat);
        mBtnStartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取我们发起聊天的者的username
                String chatId = mEditChatId.getText().toString().trim();
                if (!TextUtils.isEmpty(chatId)) {
                    // 获取当前登录用户的 username
                    String currUsername = EMClient.getInstance().getCurrentUser();
                    if (chatId.equals(currUsername)) {
                        Toast.makeText(ECMainActivity.this, "不能和自己聊天", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // 跳转到聊天界面，开始聊天
                    Intent intent = new Intent(ECMainActivity.this, ECChatActivity.class);
                    intent.putExtra("ec_chat_id", chatId);
                    startActivity(intent);
                } else {
                    Toast.makeText(ECMainActivity.this, "Username 不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });

        mBtnLogout = (Button) findViewById(R.id.btn_logout);
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    /**
     * 退出登录
     */
    private void logout() {
        // 调用sdk的退出登录方法，第一个参数表示是否解绑推送的token，没有使用推送或者被踢都要传false
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                Log.i("lzan13", "logout success");
                // 调用退出成功，结束app
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.i("lzan13", "logout error " + i + " - " + s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
