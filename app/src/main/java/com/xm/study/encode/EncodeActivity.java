package com.xm.study.encode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xm.study.R;
import com.xm.study.base.BaseActivity;
import com.xm.study.encode.presenter.EncodeComplPresenter;
import com.xm.study.encode.presenter.IEncodePresenter;
import com.xm.study.encode.view.IEncodeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EncodeActivity extends BaseActivity implements IEncodeView {


    @Bind(R.id.edt_encode)
    EditText edtEncode;
    @Bind(R.id.tv_result_encode)
    TextView tvResultEncode;
    @Bind(R.id.tv_result_decode)
    TextView tvResultDecode;
    @Bind(R.id.btn_encode_aes)
    Button btnEncodeAes;
    @Bind(R.id.btn_decode_aes)
    Button btnDecodeAes;
    @Bind(R.id.btn_encode_aes_2)
    Button btnEncodeAes2;
    @Bind(R.id.btn_decode_aes_2)
    Button btnDecodeAes2;
    @Bind(R.id.btn_encode_rsa)
    Button btnEncodeRsa;
    @Bind(R.id.btn_decode_rsa)
    Button btnDecodeRsa;
    @Bind(R.id.btn_encode_des3)
    Button btnEncodeDes3;
    @Bind(R.id.btn_decode_des3)
    Button btnDecodeDes3;
    @Bind(R.id.btn_encode_md5)
    Button btnEncodeMd5;
    @Bind(R.id.btn_decode_md5)
    Button btnDecodeMd5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_test);
        ButterKnife.bind(this);
        iPresenter = new EncodeComplPresenter(this, this);
    }

    @OnClick({R.id.btn_encode_aes, R.id.btn_decode_aes, R.id.btn_encode_aes_2, R.id.btn_decode_aes_2,
            R.id.btn_encode_rsa, R.id.btn_decode_rsa, R.id.btn_encode_des3, R.id.btn_decode_des3,
            R.id.btn_encode_md5, R.id.btn_decode_md5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_encode_aes:
                ((IEncodePresenter) iPresenter).encodeAes(edtEncode.getText().toString());
                break;
            case R.id.btn_decode_aes:
                ((IEncodePresenter) iPresenter).decodeAes(tvResultEncode.getText().toString());
                break;
            case R.id.btn_encode_aes_2:
                ((IEncodePresenter) iPresenter).encodeAes2(edtEncode.getText().toString());
                break;
            case R.id.btn_decode_aes_2:
                ((IEncodePresenter) iPresenter).decodeAes2(tvResultEncode.getText().toString());
                break;
            case R.id.btn_encode_rsa:
                ((IEncodePresenter) iPresenter).encodeRsa(edtEncode.getText().toString());
                break;
            case R.id.btn_decode_rsa:
                ((IEncodePresenter) iPresenter).decodeRsa(tvResultEncode.getText().toString());
                break;
            case R.id.btn_encode_des3:
                ((IEncodePresenter) iPresenter).encodeDes3(edtEncode.getText().toString());
                break;
            case R.id.btn_decode_des3:
                ((IEncodePresenter) iPresenter).decodeDes3(tvResultEncode.getText().toString());
                break;
            case R.id.btn_encode_md5:
                ((IEncodePresenter) iPresenter).encodeMd5(edtEncode.getText().toString());
                break;
            case R.id.btn_decode_md5:
                ((IEncodePresenter) iPresenter).decodeMd5(tvResultEncode.getText().toString());
                break;
        }
    }

    private void encode(String strEncode) {
        tvResultEncode.setText(strEncode);
    }

    private void decode(String strDecode) {
        tvResultDecode.setText(strDecode);
    }

    @Override
    public void encodeAes(String strEncode) {
        encode(strEncode);
    }

    @Override
    public void decodeAes(String strDecode) {
        decode(strDecode);
    }

    @Override
    public void encodeAes2(String strEncode) {
        encode(strEncode);
    }

    @Override
    public void decodeAes2(String strDecode) {
        decode(strDecode);
    }

    @Override
    public void encodeDes3(String strEncode) {
        encode(strEncode);
    }

    @Override
    public void decodeDes3(String strDecode) {
        decode(strDecode);
    }

    @Override
    public void encodeMd5(String strEncode) {
        encode(strEncode);
    }

    @Override
    public void decodeMd5(String strDecode) {
        decode(strDecode);
    }

    @Override
    public void encodeRsa(String strEncode) {
        encode(strEncode);
    }

    @Override
    public void decodeRsa(String strDecode) {
        decode(strDecode);
    }
}
