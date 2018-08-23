package com.fly.kuaixun.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.fly.kuaixun.tool.LogUtil;
import com.fly.kuaixun.ui.NewsActivity;
import com.fly.kuaixun.ui.WebActivity;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

/**
 * 自定义接收器
 * 
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 *
 *  在这里 我暂时并没有处理 消息来做某些事情，比如 跳转网页什么的
 *  暂时只是来消息后，分发一条消息到主页，弹出个效果  (by fan)
 *  后面我会添加上这部分内容
 */
public class JpushCustomReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			Bundle bundle = intent.getExtras();
			LogUtil.e( "[JpushCustomReceiver] onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));
			if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
				String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
				LogUtil.e( "[JpushCustomReceiver] 接收Registration Id : " + regId);
				//send the Registration Id to your server...
			} else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
				LogUtil.e( "[JpushCustomReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
				processCustomMessage(context, bundle);
				// 收到 自定义消息  ====》by fan
			} else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
				LogUtil.e( "[JpushCustomReceiver] 接收到推送下来的通知");
				EventBus.getDefault().post("Jpush_message_come");  //不推荐使用String
				int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
				// 收到 通知  ====》by fan     富媒体和通知  在一起
				LogUtil.e( "[JpushCustomReceiver] 接收到推送下来的通知的ID: " + notifactionId);
			} else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
				LogUtil.e( "[JpushCustomReceiver] 用户点击打开了通知");
				//打开自定义的Activity
//				Intent i = new Intent(context, WebActivity.class);
//				i.putExtras(bundle);
//				//i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
//				context.startActivity(i);
			} else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
				LogUtil.e("===========比如打开新的Activity， 打开一个网页等");
				LogUtil.e( "[JpushCustomReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
				//在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

			} else if(JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
				boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
				LogUtil.e( "[JpushCustomReceiver]" + intent.getAction() +" connected state change to "+connected);
			} else {
				LogUtil.e( "[JpushCustomReceiver] Unhandled intent - " + intent.getAction());
			}
		} catch (Exception e){

		}

	}

	// 打印所有的 intent extra 数据
	private static String printBundle(Bundle bundle) {
		StringBuilder sb = new StringBuilder();
		for (String key : bundle.keySet()) {
			if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
				sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
			}else if(key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)){
				sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
			} else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
				if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
					LogUtil.e( "This message has no Extra data");
					continue;
				}

				try {
					JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
					Iterator<String> it =  json.keys();

					while (it.hasNext()) {
						String myKey = it.next();
						sb.append("\nkey:" + key + ", value: [" +
								myKey + " - " +json.optString(myKey) + "]");
					}
				} catch (JSONException e) {
					LogUtil.e( "Get message extra JSON error!");
				}

			} else {
				sb.append("\nkey:" + key + ", value:" + bundle.get(key));
			}
		}
		return sb.toString();
	}
	
	//send msg to MainActivity
	private void processCustomMessage(Context context, Bundle bundle) {
			String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
			String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
			LogUtil.e("=================消息："+message);
			//Intent msgIntent = new Intent(MainActivity.MESSAGE_RECEIVED_ACTION);
		//	msgIntent.putExtra(MainActivity.KEY_MESSAGE, message);
			if (!ExampleUtil.isEmpty(extras)) {
				try {
					JSONObject extraJson = new JSONObject(extras);
					if (extraJson.length() > 0) {
					//	msgIntent.putExtra(MainActivity.KEY_EXTRAS, extras);
					}
				} catch (JSONException e) {

				}

			}

	}
}
