package com.example.master.drawer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Snackbar mSnackbar;

    private static final int  NOTIFLY_ID = 101;//Идентификатор увидомления

    View.OnClickListener snackbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"Great!",Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button buttonMenu = (Button)findViewById(R.id.button_menu);
        TextView textMenu = (TextView)findViewById(R.id.text_1);
        ImageView imageManu=(ImageView)findViewById(R.id.image_1);

        buttonMenu.setOnClickListener(viewClickListener);
        textMenu.setOnClickListener(viewClickListener);
        imageManu.setOnClickListener(viewClickListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar = Snackbar.make(view, "Отправить СМС?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Yes!", snackbarOnClickListener);
                mSnackbar.show();
            }
        });
    }

    View.OnClickListener viewClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            showPopupMenu(view);

        }
    };

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popupmenu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 1",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 2",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(),
                                "Вы выбрали PopupMenu 3",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }


        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu popupMenu) {
                Toast.makeText(getApplicationContext(),"onDismiss",Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView text =(TextView)findViewById(R.id.text_info);
        //noinspection SimplifiableIfStatement
        switch (id){
            case  R.id.action_title1:
                text.setText(R.string.click_t1);
                return true;

            case  R.id.action_title2:
                text.setText(R.string.click_t2);
                return true;

            case  R.id.action_title3:
                text.setText(R.string.click_t3);
                return true;

        }
        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(getApplicationContext(), "Вы выбрали камеру", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "Вы выбрали галлерею", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(getApplicationContext(), "Вы выбрали ультрапоказ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(getApplicationContext(), "Вы выбрали Tools", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(), "Вы выбрали поделиться", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(), "Вы выбрали отправить", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_music) {
            Toast.makeText(getApplicationContext(), "Вы выбрали музыку", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClick(View view) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent cottentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = this.getResources();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

switch (view.getId()){
    case R.id.button_notification1:
       builder
            .setSmallIcon(R.drawable.eat)
            //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
            .setContentTitle("Напоминание")
            //.setContentText(res.getString(R.string.notifytext))
            .setContentText("Пора на работу") // Текст уведомления
            // необязательные настройки
            .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.work)) // большая
            // картинка
            //.setTicker(res.getString(R.string.warning)) // текст в строке состояния
            .setTicker("Быстрее!")
               .setColor(Color.BLUE)
            .setWhen(System.currentTimeMillis())
            .setAutoCancel(true); // автоматически закрыть уведомление после нажатия
        notificationManager.notify(1, builder.build());

        break;
    case R.id.button_notification2:
builder                .setSmallIcon(R.drawable.eat)
                //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
                .setContentTitle("Напоминание")
                //.setContentText(res.getString(R.string.notifytext))
                .setContentText("Пора поесть") // Текст уведомления
                // необязательные настройки
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.eat)) // большая
                // картинка
                //.setTicker(res.getString(R.string.warning)) // текст в строке состояния
                .setTicker("Последнее китайское предупреждение!")
        .setColor(Color.YELLOW)
        .setWhen(System.currentTimeMillis())
                .setAutoCancel(true); // автоматически закрыть уведомление после нажатия


        notificationManager.notify(2, builder.build());
        break;
    case R.id.button_notification3:
builder                .setSmallIcon(R.drawable.eat).setContentIntent(cottentIntent)
                //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
                .setContentTitle("Напоминание")
                //.setContentText(res.getString(R.string.notifytext))
                .setContentText("Пора домой")
        .addAction(R.color.none,"Ура",cottentIntent)
        .addAction(R.color.none,"Блин(",cottentIntent)
        .addAction(R.color.none,"Я никуда не пойду",cottentIntent)

        // необязательные настройки
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.home)) // большая
                // картинка
                //.setTicker(res.getString(R.string.warning)) // текст в строке состояния
                .setTicker("Иди уже!")
        .setColor(Color.RED)
        .setWhen(System.currentTimeMillis())
                .setAutoCancel(true); // автоматически закрыть уведомление после нажатия
        notificationManager.notify(3, builder.build());
        break;
case R.id.button_del:
    notificationManager.cancelAll();
}


    }

}



