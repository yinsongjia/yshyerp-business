package com.yshyerp.business.controller;

import com.alibaba.fastjson.JSON;
import com.yshyerp.business.controller.common.ControllerTemplate;
import com.yshyerp.business.entity.Contracttank;
import com.yshyerp.business.mapper.CommodityMapper;
import com.yshyerp.business.request.Request;
import com.yshyerp.business.response.Response;
import com.yshyerp.business.response.dto.ContracttankDTO;
import com.yshyerp.business.service.ContracttankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yshyerp.business.response.dto.DropDownBoxDTO;
import com.yshyerp.business.utils.ExcelReader;
import com.yshyerp.business.utils.ExcelUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/18
 * @Description:
 */
//是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
@RequestMapping("contracttank/")
@RestController
@Slf4j
public class ContracttankController implements ControllerTemplate<Contracttank> {
//    private final String[] HEADERS = {"罐号", "货品", "最小量", "备注", "作业方式", "罐号", "单价", "商检单号"}; //列标题
//    private final String FILE_NAME = "储罐相关详细Excel模板.xls"; //模板名称
    @Autowired
    private ContracttankService contracttankService;

    @Override
    public Response getDetail(String request) {
        return null;
    }

    @Override
    public Response getUpdateInit(String request) {
        return null;
    }

    @Override
    public Response addPost(Request<Contracttank> request) {
        log.info("addContracttank报文:{}", JSON.toJSONString(request));
        Response response = contracttankService.addContracttank(request);
        log.info("addContracttank报文:{}", JSON.toJSONString(response));
        return response;
    }

    //@PathVariable  接收请求路径中占位符的值
    @GetMapping("getContracttankById/{billid}")
    public Response getContracttankById(@PathVariable Integer billid) {
        log.info("getContracttankById报文:{}", JSON.toJSONString(billid));
        Response response = contracttankService.getContracttankById(billid);
        log.info("getContracttankById报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response delete(Request request) {
        log.info("delete Response报文:{}",JSON.toJSONString(request));
        List<Integer>list= JSON.parseArray(JSON.toJSONString(request.getData()),Integer.class);
        Response response=contracttankService.delete(list);
        log.info("delete Response报文:{}",JSON.toJSONString(response));
        return  response;
    }

    @Override
    public Response updatePut(Request<Contracttank> request) {
        log.info("updateContracttank报文:{}", JSON.toJSONString(request));
        Response response = contracttankService.updateContracttank(request);
        log.info("updateContracttank报文:{}", JSON.toJSONString(response));
        return response;
    }

    @Override
    public Response getDropDownInit() {

        return contracttankService.qyery();
    }

    @Override
    public Response getAddDropDownInit() {
        return null;
    }

    @Override
    public Response postListInit(Request<Contracttank> request) {
        log.info("getContracttank Response报文:{}", JSON.toJSONString(request));
        Response response = contracttankService.getContracttank(request);
        return response;
    }


    /**
     * 储罐相关修改信息点击下载  下载子表详细Excel
     *
     * @param tank
     * @param request
     * @return
     */
//    @GetMapping("execlupdateDrop/{tank}")
//    public Response getContracttankcById(@PathVariable Request<Contracttank> tank, HttpServletRequest request) {
//        Response response = null;
//        Map<String, Object> json;
//        try {
//            Map<String, Object> map = new HashMap<>();
//            List<Contracttank> list = JSON.parseArray(JSON.toJSONString(contracttankService.updateContracttank(tank).getData()), Contracttank.class);
//            List<Map<String, String>> processStepList = new ArrayList<>();
//            for (Contracttank processItem : list) {
//                Map<String, String> processStep = new HashMap<>();
//                processStep.put("罐号", processItem.getTank());
//                processStep.put("货品", processItem.getCommodity());
//                processStep.put("最小量", processItem.getMinInput() + "");
//                processStep.put("罐号", processItem.getRemarks());
//                processStepList.add(processStep);
//            }
//            List<String> stringList = new ArrayList<>();
//            List<String> stringList1 = new ArrayList<>();
//            List<String> stringList2 = new ArrayList<>();
//            List<Map<String, Object>> stationGroupList = this.getDropDown(JSON.parseArray(JSON.toJSONString(contracttankService.qyery().getData()), DropDownBoxDTO.class));
//            if (!CollectionUtils.isEmpty(stationGroupList)) {
//                for (Map<String, Object> contracttank : stationGroupList) {
//                    String key = String.valueOf(contracttank.get("key"));
//                    String value = String.valueOf(contracttank.get("label"));
//                    stringList.add(key + "-" + value);
//                }
//            }
//            List<Map<String, Object>> commodityList = this.getDropDown(commodityMapper.qyery());
//            if (!CollectionUtils.isEmpty(commodityList)) {
//                for (Map<String, Object> commodity : commodityList) {
//                    String key = String.valueOf(map.get("key")).replaceAll("\\s", "");
//                    ;
//                    String value = String.valueOf(map.get("label")).replaceAll("\\s", "");
//                    ;
//                    stringList1.add(value);
//                }
//            }
//            //下拉框数据
//            List<String[]> downData = new ArrayList<>();
//            String[] str1 = stringList.toArray(new String[0]);
//            String[] str2 = stringList1.toArray(new String[0]);
//
//            downData.add(str1);
//            downData.add(str2);
//            String[] downRows = {"0", "1"}; //下拉框的列序号数组(序号从0开始)
//            String webappPath = request.getSession().getServletContext().getRealPath("/upload");
//            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload";
//
//            //windows部署
//            String path = webappPath + "\\" + this.FILE_NAME;
//
//            ExcelUtil.createExcelTemplate(path, this.HEADERS, downData, downRows, processStepList);
//            map.put("FilePath", filePath + this.FILE_NAME);
//            response = Response.success("查询成功", map);
//        } catch (Exception e) {
//            response = Response.error(e.getMessage());
//            log.error("{}", e);
//            e.printStackTrace();
//        }
//        return response;
//    }
//
//    /**
//     * 储罐相关子表 添加的时候  excel下载
//     */
//    @GetMapping("excelAddDrop")
//    public Response excelAddDrop(HttpServletRequest request) {
//        Response response = null;
//        List<String> stringList = new ArrayList<>();
//        List<String> stringList1 = new ArrayList<>();
//        List<String> stringList2 = new ArrayList<>();
//        List<Map<String, Object>> stationGroupList = this.getDropDown(JSON.parseArray(JSON.toJSONString(contracttankService.qyery().getData()), DropDownBoxDTO.class));
//        if (!CollectionUtils.isEmpty(stationGroupList)) {
//            for (Map<String, Object> contracttank : stationGroupList) {
//                String key = String.valueOf(contracttank.get("key"));
//                String value = String.valueOf(contracttank.get("label"));
//                stringList.add(key + "-" + value);
//            }
//        }
//        List<Map<String, Object>> commodityList = this.getDropDown(commodityMapper.qyery());
//        if (!CollectionUtils.isEmpty(commodityList)) {
//            for (Map<String, Object> map : commodityList) {
//                String key = String.valueOf(map.get("key")).replaceAll("\\s", "");
//                ;
//                String value = String.valueOf(map.get("label")).replaceAll("\\s", "");
//                ;
//                stringList1.add(value);
//            }
//        }
//        //下拉框数据
//        List<String[]> downData = new ArrayList<>();
//        String[] str1 = stringList.toArray(new String[0]);
//        String[] str2 = stringList1.toArray(new String[0]);
//
//        downData.add(str1);
//        downData.add(str2);
//        String[] downRows = {"0", "1"}; //下拉框的列序号数组(序号从0开始)
//        String webappPath = request.getSession().getServletContext().getRealPath("/upload");
//        String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload";
//        try {
//            //windows部署
//            String path = webappPath + "\\" + this.FILE_NAME;
//            String[] headers = {"罐号", "货品", "最小量", "备注"}; //列标题
//            ExcelUtil.createExcelTemplate(path, headers, downData, downRows, null);
//            Map<String, Object> map = new HashMap<>();
//            map.put("FilePath", filePath + this.FILE_NAME);
//            response = Response.success("获取导入模板成功", map);
//        } catch (Exception e) {
//            response = Response.error("获取储罐模板成功");
//            log.error("批量导入信息异常:" + e.getMessage());
//        }
//        return response;
//    }


    /**
     * 储罐主表 子表添  （excel获取数据） 修改主表子表
     * @param upfile
     * @param contracttankDTO
     * @param request
     * @return
     * @throws Exception
     */
//    @PostMapping("update")
//    public Response updateDataForProcess(@RequestParam("file") CommonsMultipartFile upfile, ContracttankDTO contracttankDTO, HttpServletRequest request) throws Exception{
//        Response response = null;
//        try {
//            contracttankDTO  = this.getVtimeDTO(upfile,request,contracttankDTO);
//            log.info("postListInit Request：{}", JSON.toJSONString(contracttankDTO));
//            response =contracttankService.updateContracttank(contracttankDTO);
//            log.info("postListInit Response报文：{}", JSON.toJSONString(response));
//        }catch (IOException e){
//            response = Response.error(e.getMessage());
//            log.error("{}",e);
//        } catch (Exception e) {
//            response = Response.error(e.getMessage());
//            log.error("{}",e);
//        }
//        return response;
//    }
//
//    @PostMapping("insert")
//    public  Response insert(@RequestParam("file") CommonsMultipartFile upfile,ContracttankDTO contracttankDTO,HttpServletRequest request)throws  Exception{
//        Response  response=null;
//        try {
//            if(StringUtils.isEmpty(contracttankDTO.getTank())){
//                return  Response.error("罐号不能为空");
//            }
//           Contracttank contracttank=JSON.parseObject(JSON.toJSONString(contracttankService.getContracttankById(contracttankDTO.getBillid()).getData()),Contracttank.class);
//            contracttankDTO.setTank(contracttank.getTank());
//            contracttankDTO=this.getVtimeDTO(upfile,request,contracttankDTO);
//            log.info("",JSON.toJSONString(contracttankDTO));
//            response =contracttankService.addContracttank(contracttankDTO);
//            log.info("",JSON.toJSONString(response));
//        }catch (IOException e){
//            response=Response.error(e.getMessage());
//            log.error("{}",e);
//        }catch (Exception e){
//            response=Response.error(e.getMessage());
//            log.error("{}",e);
//        }
//        return  response;
//        }

//    /**
//     * 解析execl数据.
//     *
//     * @param upfile
//     * @param request
//     * @param contracttankDTO
//     * @return
//     * @throws IOException
//     */
//    private ContracttankDTO getVtimeDTO(CommonsMultipartFile upfile, HttpServletRequest request, ContracttankDTO contracttankDTO) throws IOException {
//        String path = request.getSession().getServletContext().getRealPath("/upload");
//        if (!StringUtils.isEmpty(upfile) && upfile.getSize() != 0) {
//            File file = new File(path, upfile.getOriginalFilename());
//            FileUtils.copyInputStreamToFile(upfile.getInputStream(), file);
//            ExcelReader excelReader = new ExcelReader();
//            List<Map<String, Object>> dataList = excelReader.readExcel(file.getPath(), 1);
//            List<Map> mlist = ExcelUtil.toSingle(dataList);
//            List<Contracttank> processSteps = new ArrayList<>();
//            int i = 2;
//            for (Map m : mlist) {
//                Contracttank contracttank = new Contracttank();
//                contracttank.setTank(m.get("tank") == null ? null : m.get("tank").toString());
//                contracttank.setCommodity(m.get("commodity") == null ? null : m.get("commodity").toString());
//                contracttank.setRemarks(m.get("remarks") == null ? null : m.get("remarks").toString());
//                contracttank.setMinInput(contracttankDTO.getMin_input());
//                processSteps.add(contracttank);
//                if (StringUtils.isEmpty(contracttank.getTank())) {
//                    throw new IOException("第" + i + "行储罐罐号不能为空");
//                }
//                if (StringUtils.isEmpty(contracttank.getCommodity())) {
//                    throw new IOException("第" + i + "行货品不能为空");
//                }
//                if (StringUtils.isEmpty(contracttank.getMinInput())) {
//                    throw new IOException("第" + i + "行最小量不能为空");
//                }
//                if (StringUtils.isEmpty(contracttank.getRemarks())) {
//                    throw new IOException("第" + i + "行备注不能为空");
//                }
//                i++;
//            }
//            contracttankDTO.equals(processSteps);
//            log.info(JSON.toJSONString(processSteps));
//        }
//        return contracttankDTO;
//    }


    /**
     * 设置下拉菜单的值
     *
     * @return
     */
//    private List<Map<String, Object>> getDropDown(List<DropDownBoxDTO> list) {
//        List<DropDownBoxDTO> stationGroups = list;
//        List<Map<String, Object>> sGList = new ArrayList<>();
//        for (DropDownBoxDTO stationGroup : stationGroups) {
//            Map<String, Object> sG = new HashMap<>();
//            sG.put("key", stationGroup.getKey());
//            sG.put("label", stationGroup.getValue());
//            sGList.add(sG);
//        }
//        return sGList;
//    }

}

