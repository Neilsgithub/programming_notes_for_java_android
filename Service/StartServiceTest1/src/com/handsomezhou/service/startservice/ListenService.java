package com.handsomezhou.service.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ListenService extends Service {

	//����ʵ�ֵķ���
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//Service������ʱ�ص��÷���
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("Service is Created");
	}

	//Service������ʱ�ص��÷���
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Service is Started");
		return Service.START_STICKY;
	}
	
	//Service���ر�֮ǰ�ص�
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("Service is Destroyed");
	}
	

}
