package com.test.page.source.myaccount;

import org.openqa.selenium.WebDriver;

import com.test.utils.element.ExtendWebElement;
import com.test.utils.element.Locator;

public class FixedInvestmentPage {

	private Locator locator;
	public FixedInvestmentPage(WebDriver driver) {
		this.locator = new Locator(driver, "locator/myAccount");
	}

	private ExtendWebElement ava_fixed;
	private ExtendWebElement unava_fixed;
	private ExtendWebElement fixed_list;
	private ExtendWebElement add_fixed;
	
	private ExtendWebElement perfer_fund;
	private ExtendWebElement all_fund;
	private ExtendWebElement fund_list;
	private ExtendWebElement all_fund_list;
	
	private ExtendWebElement fund_source;
	private ExtendWebElement pay_cycle;
	private ExtendWebElement fix_amount;
	
	private ExtendWebElement bank_list;
	private ExtendWebElement cycle_list;
	private ExtendWebElement confirm_cycle_btn;
	
	private ExtendWebElement next_step_btn;
	private ExtendWebElement pwd;
	private ExtendWebElement comfirm_btn;
	
	private ExtendWebElement title;
	private ExtendWebElement step4_title;
	
	private ExtendWebElement step5;
	private ExtendWebElement ava_fixList;
	
	//定投明细
	private ExtendWebElement box;
	private ExtendWebElement pause_btn;
	private ExtendWebElement edit_btn;
	
	private ExtendWebElement pause_pwd;
	private ExtendWebElement cancel_btn_holder;
	private ExtendWebElement confirm_btn_holder;
	
	private ExtendWebElement save_btn;
	private ExtendWebElement confirm_btn_edit;
	
	private ExtendWebElement step_3;
	
	/**
	 * @Description 有效定投
	 * @return
	 */
	public ExtendWebElement getAva_fixed() {
		ava_fixed = locator.getElement("ava_fixed");
		return ava_fixed;
	}
	
	/**
	 * @Description 已暂停定投
	 * @return
	 */
	public ExtendWebElement getUnava_fixed() {
		unava_fixed = locator.getElement("unava_fixed");
		return unava_fixed;
	}
	
	/**
	 * @Description 定投列表
	 * @return
	 */
	public ExtendWebElement getFixed_list() {
		fixed_list = locator.getElement("fixed_list");
		return fixed_list;
	}
	
	/**
	 * @Description 添加定投
	 * @return
	 */
	public ExtendWebElement getAdd_fixed() {
		add_fixed = locator.getElement("add_fixed");
		return add_fixed;
	}
	
	/**
	 * @Description 优选基金
	 * @return
	 */
	public ExtendWebElement getPerfer_fund() {
		perfer_fund = locator.getElement("perfer_fund");
		return perfer_fund;
	}
	
	/**
	 * @Description 全部基金
	 * @return
	 */
	public ExtendWebElement getAll_fund() {
		all_fund = locator.getElement("all_fund");
		return all_fund;
	}
	
	/**
	 * @Description 优选基金列表
	 * @return
	 */
	public ExtendWebElement getFund_list() {
		fund_list = locator.getElement("fund_list");
		return fund_list;
	}

	/**
	 * @Description 全部基金列表
	 * @return
	 */
	public ExtendWebElement getAll_fund_list() {
		all_fund_list = locator.getElement("all_fund_list");
		return all_fund_list;
	}

	/**
	 * @Description 资金来源
	 * @return
	 */
	public ExtendWebElement getFund_source() {
		fund_source = locator.getElement("fund_source");
		return fund_source;
	}

	/**
	 * @Description 扣款周期
	 * @return
	 */
	public ExtendWebElement getPay_cycle() {
		pay_cycle = locator.getElement("pay_cycle");
		return pay_cycle;
	}

	/**
	 * @Description 定投金额
	 * @return
	 */
	public ExtendWebElement getFix_amount() {
		fix_amount = locator.getElement("fix_amount");
		return fix_amount;
	}

	/**
	 * @Description 资金来源列表
	 * @return
	 */
	public ExtendWebElement getBank_list() {
		bank_list = locator.getElement("bank_list");
		return bank_list;
	}

	/**
	 * @Description 定投周期列表
	 * @return
	 */
	public ExtendWebElement getCycle_list() {
		cycle_list = locator.getElement("cycle_list");
		return cycle_list;
	}

	/**
	 * @Description 定投周期确认按钮
	 * @return
	 */
	public ExtendWebElement getConfirm_cycle_btn() {
		confirm_cycle_btn = locator.getElement("confirm_cycle_btn");
		return confirm_cycle_btn;
	}

	/**
	 * @Description 页面标题
	 * @return
	 */
	public ExtendWebElement getTitle() {
		title = locator.getElement("title");
		return title;
	}

	/**
	 * @Description 下一步
	 * @return
	 */
	public ExtendWebElement getNext_step_btn() {
		next_step_btn = locator.getElement("next_step_btn");
		return next_step_btn;
	}

	/**
	 * @Description 交易密码
	 * @return
	 */
	public ExtendWebElement getPwd() {
		pwd = locator.getElement("pwd");
		return pwd;
	}

	/**
	 * @Description 确认按钮
	 * @return
	 */
	public ExtendWebElement getComfirm_btn() {
		comfirm_btn = locator.getElement("comfirm_btn");
		return comfirm_btn;
	}

	/**
	 * @Description 确认定投标题
	 * @return
	 */
	public ExtendWebElement getStep4_title() {
		step4_title = locator.getElement("step4_title");
		return step4_title;
	}

	/**
	 * @Description 定投确认页面
	 * @return
	 */
	public ExtendWebElement getStep5() {
		step5 = locator.getElement("step5");
		return step5;
	}

	/**
	 * @Description 有效定投列表
	 * @return
	 */
	public ExtendWebElement getAva_fixList() {
		ava_fixList = locator.getElement("ava_fixList");
		return ava_fixList;
	}

	/**
	 * @Description 定投明细
	 * @return
	 */
	public ExtendWebElement getBox() {
		box = locator.getElement("box");
		return box;
	}

	/**
	 * @Description 暂停定投按钮
	 * @return
	 */
	public ExtendWebElement getPause_btn() {
		pause_btn = locator.getElement("pause_btn");
		return pause_btn;
	}

	/**
	 * @Description 修改定投按钮
	 * @return
	 */
	public ExtendWebElement getEdit_btn() {
		edit_btn = locator.getElement("edit_btn");
		return edit_btn;
	}

	/**
	 * @Description 弹出框密码
	 * @return
	 */
	public ExtendWebElement getPause_pwd() {
		pause_pwd = locator.getElement("pause_pwd");
		return pause_pwd;
	}

	/**
	 * @Description 取消按钮
	 * @return
	 */
	public ExtendWebElement getCancel_btn_holder() {
		cancel_btn_holder = locator.getElement("cancel_btn_holder");
		return cancel_btn_holder;
	}

	/**
	 * @Description 确定按钮
	 * @return
	 */
	public ExtendWebElement getConfirm_btn_holder() {
		confirm_btn_holder = locator.getElement("confirm_btn_holder");
		return confirm_btn_holder;
	}

	/**
	 * @Description 保存按钮
	 * @return
	 */
	public ExtendWebElement getSave_btn() {
		save_btn = locator.getElement("save_btn");
		return save_btn;
	}

	/**
	 * @Description 确认修改定投按钮
	 * @return
	 */
	public ExtendWebElement getConfirm_btn_edit() {
		confirm_btn_edit = locator.getElement("confirm_btn_edit");
		return confirm_btn_edit;
	}

	/**
	 * @Description 修改定投页面
	 * @return
	 */
	public ExtendWebElement getStep_3() {
		step_3 = locator.getElement("step_3");
		return step_3;
	}
	
	
}
