package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author inada
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 従業員一覧を取得する.
	 * 
	 * @return 従業員一覧情報
	 */
	public List<Employee> showList() {
		return employeeRepository.findAll();
	}

	/**
	 * 従業員情報を取得する.
	 * 
	 * @param id 従業員ID
	 * @return 検索した従業員情報
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}

	/**
	 * 従業員情報を更新する.
	 * 
	 * @param employee 更新する従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
}
