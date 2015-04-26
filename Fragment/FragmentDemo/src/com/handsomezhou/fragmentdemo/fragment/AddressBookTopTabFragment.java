package com.handsomezhou.fragmentdemo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handsomezhou.fragmentdemo.R;
import com.handsomezhou.fragmentdemo.view.PagerSlidingTabStrip;

public class AddressBookTopTabFragment extends BaseFragment {

	private TelephoneFragment mTelephoneFragment;
	private ContactsFragment mContactsFragment;
	private SmsFragment mSmsFragment;

	private List<String> mTitles;

	private PagerSlidingTabStrip mPagerSlidingTabStrip;
	private DisplayMetrics mDisplayMetrics;

	@Override
	protected void initData() {
		setContext(getActivity().getApplicationContext());
		mDisplayMetrics = getResources().getDisplayMetrics();

		// init title
		mTitles = new ArrayList<String>();
		mTitles.add(getResources().getString(R.string.telephone));
		mTitles.add(getResources().getString(R.string.contacts));
		mTitles.add(getResources().getString(R.string.sms));

	}

	@Override
	protected View initView(LayoutInflater inflater, ViewGroup container) {
		View view=inflater.inflate(R.layout.fragment_address_book_top_tab, container, false);
		mPagerSlidingTabStrip=(PagerSlidingTabStrip) view.findViewById(R.id.pager_sliding_tab_strip);
		ViewPager view_pager=(ViewPager)view.findViewById(R.id.view_pager);
		FragmentManager fm=this.getActivity().getSupportFragmentManager();
		view_pager.setAdapter(new TelephoneFragmentPagerAdapter(fm,mTitles));
		mPagerSlidingTabStrip.setViewPager(view_pager);
		setPagerSlidingTabStripValue();
		return view;
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub

	}
	
	private void setPagerSlidingTabStripValue(){
		// ����Tab���Զ��������Ļ��
		mPagerSlidingTabStrip.setShouldExpand(true);
		// ����Tab�ķָ�����͸����
		mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
		// ����Tab�ײ��ߵĸ߶�
		mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP, 1, mDisplayMetrics));
		// ����Tab Indicator�ĸ߶�
		mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_DIP, 4, mDisplayMetrics));
		// ����Tab�������ֵĴ�С
		mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_SP, 16, mDisplayMetrics));
		// ����Tab Indicator����ɫ
		mPagerSlidingTabStrip.setIndicatorColor(Color.parseColor("#45c01a"));
		// ����ѡ��Tab���ֵ���ɫ (�������Զ����һ������)
		mPagerSlidingTabStrip.setSelectedTextColor(Color.parseColor("#45c01a"));
		// ȡ�����Tabʱ�ı���ɫ
		mPagerSlidingTabStrip.setTabBackground(0);
	}
	
	public class TelephoneFragmentPagerAdapter extends FragmentPagerAdapter{
		private List<String> mTelephoneTitleList;
		public TelephoneFragmentPagerAdapter(FragmentManager fm,List<String> titleList) {
			super(fm);
			mTelephoneTitleList=titleList;
		}

		
		@Override
		public CharSequence getPageTitle(int position) {
			return mTelephoneTitleList.get(position);
		}


		@Override
		public Fragment getItem(int position) {
			Fragment fragment=null;
			switch (position) {
			case 0:
				if(null==mTelephoneFragment){
					mTelephoneFragment=new TelephoneFragment();
				}
				fragment=mTelephoneFragment;
				break;
			case 1:
				if(null==mContactsFragment){
					mContactsFragment=new ContactsFragment();
				}
				fragment=mContactsFragment;
				break;
			case 2:
				if(null==mSmsFragment){
					mSmsFragment=new SmsFragment();
				}
				fragment=mSmsFragment;
				break;
			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			
			return mTelephoneTitleList.size();
		}
		
	}
}
