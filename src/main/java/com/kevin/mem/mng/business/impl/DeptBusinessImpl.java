package com.kevin.mem.mng.business.impl;

import com.github.pagehelper.Page;
import com.kevin.common.domain.response.BaseResponse;
import com.kevin.common.domain.response.PageQueryResponse;
import com.kevin.mem.mng.business.DeptBusiness;
import com.kevin.mem.mng.common.PageRequest;
import com.kevin.mem.mng.domain.entity.Dept;
import com.kevin.mem.mng.dto.request.dept.*;
import com.kevin.mem.mng.dto.response.dept.DeptPageResDTO;
import com.kevin.mem.mng.service.BaseService;
import com.kevin.mem.mng.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门BusinessImpl
 * @author 丁海峰
 * @date 2018-12-09 02:18:05
 */
@Service
@Slf4j
public class DeptBusinessImpl implements DeptBusiness {

    @Autowired
    private Mapper mapper;

    @Autowired
    private DeptService deptService;

    @Override
    public BaseResponse insertDept(DeptInsertReqDTO dept) {

        int result = deptService.insert(mapper.map(dept,Dept.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchInsertDept(DeptBatchInsertReqDTO deptBatchInsertReqDTO) {
        List<Dept> deptList = deptBatchInsertReqDTO.getInsertDeptList().stream()
                .map(item-> mapper.map(item, Dept.class)).collect(Collectors.toList());
        deptService.batchInsert(deptList);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse updateDept(DeptUpdateReqDTO dept) {
        int result = deptService.updateById(mapper.map(dept,Dept.class));

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchUpdateDept(DeptBatchUpdateReqDTO deptBatchUpdateReqDTO) {
        List<Dept> deptList = deptBatchUpdateReqDTO.getUpdateDeptList().stream()
                .map(item-> mapper.map(item, Dept.class)).collect(Collectors.toList());
        deptService.batchUpdate(deptList);
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse deleteDept(Long id) {
        int result = deptService.deleteById(id);

        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse batchDeleteDept(DeptBatchDeleteReqDTO reqDTO) {
        deptService.batchDelete(reqDTO.getIdList());
        return BaseResponse.createSuccessResult(null);
    }

    @Override
    public BaseResponse queryDept(Long id) {
        Dept result = deptService.selectByCode(id);
        return BaseResponse.createSuccessResult(mapper.map(result, DeptPageResDTO.class));
    }

    @Override
    public PageQueryResponse<DeptPageResDTO> queryPage(PageRequest<DeptPageReqDTO> pageRequest) {

        PageRequest<Dept> request = new PageRequest();
        request.setPageIndex(pageRequest.getPageIndex());
        request.setPageSize(pageRequest.getPageSize());

        if (Objects.nonNull(pageRequest.getModel())) {
            request.setModel(mapper.map(pageRequest.getModel(), Dept.class));
        }

        Page<Dept> deptList = deptService.queryPage(request);

        List<DeptPageResDTO> deptPageResDTOList = deptList.stream().map(item->mapper
                .map(item,DeptPageResDTO.class)).collect(Collectors.toList());

        PageQueryResponse<DeptPageResDTO> pageQueryResponse = PageQueryResponse.createSuccessResult(deptPageResDTOList);

        pageQueryResponse.setTotalCount((int)deptList.getTotal());
        pageQueryResponse.setPageSize(pageRequest.getPageSize());
        pageQueryResponse.setPageIndex(pageRequest.getPageIndex());

        return pageQueryResponse;
    }

    @Override
    public BaseResponse<List<DeptPageResDTO>> queryAll(DeptPageReqDTO reqDTO) {
        return BaseResponse.createSuccessResult(
                deptService.queryAll(mapper.map(reqDTO,Dept.class))
                                        .stream().map(item -> mapper.map(item,DeptPageResDTO.class))
                                                 .collect(Collectors.toList()));
    }


}
	