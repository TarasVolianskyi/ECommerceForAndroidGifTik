package com.volianskyi.taras.a121017_ecommerceforandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AdminAddUsersActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNameOfNewUserFromAdmin;
    EditText etPassOfNewUserFromAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_users);
        initView();
    }

    private void initView() {
        Button btnAdd = (Button) findViewById(R.id.btnAddNewAdminAddUsersActivity);
        btnAdd.setOnClickListener(this);
        etNameOfNewUserFromAdmin = (EditText) findViewById(R.id.etNameAdminAddUsersActivity);
        etPassOfNewUserFromAdmin = (EditText) findViewById(R.id.etPassAdminAddUsersActivity);

    }

    @Override
    public void onClick(View view) {
        String nameOfNewUser = etNameOfNewUserFromAdmin.getText().toString();
        String passOfNewUser = etPassOfNewUserFromAdmin.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME_USERS_TABLE, nameOfNewUser);
        contentValues.put(DatabaseHelper.PASS_USERS_TABLE, passOfNewUser);
        getContentResolver().insert(DatabaseHelper.URI_USERS, contentValues);
        startActivity(new Intent(AdminAddUsersActivity.this, AdminUsersActivity.class));
    }
}