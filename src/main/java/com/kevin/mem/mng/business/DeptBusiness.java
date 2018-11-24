package com.kevin.mem.mng.business;

import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.dto.request.dept.*;
import com.kevin.mem.mng.dto.response.dept.DeptPageResDTO;

import java.util.List;
/**
 * 部门Business
 * @author 丁海峰
 * @date 2018-11-24 02:18:14
 */
public interface DeptBusiness {

    BaseResponse insertDept(DeptInsertReqDTO dept);

    BaseResponse batchInsertDept(DeptBatchInsertReqDTO reqDTO);

    BaseResponse updateDept(DeptUpdateReqDTO dept);

    BaseResponse batchUpdateDept(DeptBatchUpdateReqDTO reqDTO);

    BaseResponse deleteDept(Long id);

    BaseResponse batchDeleteDept(DeptBatchDeleteReqDTO reqDTO);

    BaseResponse queryDept(Long id);

    PageQueryResponse<DeptPageResDTO> queryPage(PageRequest<DeptPageReqDTO> pageRequest);

    BaseResponse<List<DeptPageResDTO>> queryAll(DeptPageReqDTO reqDTO);

}
	