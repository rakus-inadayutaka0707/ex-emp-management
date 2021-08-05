package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービスクラス.
 * 
 * @author inada
 *
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository repository;

	/**
	 * 管理者情報を挿入する.
	 * 
	 * @param administrator 挿入する管理者情報
	 */
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
}
