package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author inada
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute
	private UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧を表示する.
	 * 
	 * @param model 従業員一覧情報を表示する情報
	 * @return 従業員一覧を表示する画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	/**
	 * 従業員一人の情報を表示する.
	 * 
	 * @param id    表示したい従業員のID
	 * @param model 従業員情報を表示するための情報
	 * @return 従業員一人の情報を表示する画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/**
	 * 従業員情報を更新する
	 * 
	 * @param form 更新したい従業員の情報
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
}
