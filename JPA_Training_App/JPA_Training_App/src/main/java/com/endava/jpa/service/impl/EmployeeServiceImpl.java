package com.endava.jpa.service.impl;

import com.endava.jpa.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
}
