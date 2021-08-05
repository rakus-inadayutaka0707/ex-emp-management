package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報を操作するコントローラー.
 * 
 * @author inada
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

	@Autowired
	private AdministratorService service;

	@ModelAttribute
	private InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	@ModelAttribute
	private LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * insert.htmlにフォワードする.
	 * 
	 * @return 管理者登録画面を表示する
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param form 入力フォーム情報
	 * @return ログイン画面へリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		service.insert(administrator);
		return "redirect:/";
	}

	/**
	 * login.htmlにフォワードする.
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
}
