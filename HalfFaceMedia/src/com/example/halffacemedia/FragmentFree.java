package com.example.halffacemedia;

import com.example.adapter.MainPagerAdapter;
import com.example.utils.HalfFaceUtil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FragmentFree extends Fragment{
	
	public static String TAG=FragmentFree.class.getSimpleName();
	private ViewPager pager;
	private RadioGroup radioGroup;
	private RadioButton[] radioButtons;
	
	public FragmentFree(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_free, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		pager=(ViewPager) view.findViewById(R.id.free_pager);
		radioGroup=(RadioGroup) view.findViewById(R.id.free_rbGroup);
		radioButtons=new RadioButton[]{
				(RadioButton) view.findViewById(R.id.free_rbVideo),
				(RadioButton) view.findViewById(R.id.free_rbPhoto),
				(RadioButton) view.findViewById(R.id.free_rbNoval),
				(RadioButton) view.findViewById(R.id.free_rbVoice)
		};
		
		pager.setAdapter(new MainPagerAdapter(getActivity().getSupportFragmentManager(),HalfFaceUtil.getMediaFragment()));
		
		//控件监听
		radioGroup.setOnCheckedChangeListener(rdGroupListener);
		pager.setOnPageChangeListener(pagerListener);
	}
	
	/**
	 * RadioGroup监听
	 */
	private RadioGroup.OnCheckedChangeListener rdGroupListener=new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.free_rbVideo:
				pager.setCurrentItem(0);
				break;
			case R.id.free_rbPhoto:
				pager.setCurrentItem(1);
				break;
			case R.id.free_rbNoval:
				pager.setCurrentItem(2);
				break;
			case R.id.free_rbVoice:
				pager.setCurrentItem(3);
				break;
			default:
				break;
			}
		}
	};
	
	private ViewPager.OnPageChangeListener pagerListener=new ViewPager.OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			for(int i=0;i<radioButtons.length;i++){
				if(arg0==i)
					radioButtons[i].setChecked(true);
				else 
					radioButtons[i].setChecked(false);
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {}
	};
}
