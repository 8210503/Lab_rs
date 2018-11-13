package com.gft.lab_rs.network;



import org.json.JSONObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by jie on 2016/12/8.
 */

public interface ApiService {


    /**
     * 抽样单信息
     */
    @POST("Account/login")
    @FormUrlEncoded
    Observable<JSONObject> Login(@Field("personname") String s,
                                 @Field("password") String p);

    /**
     * 抽样单信息
     */
    @POST("Weight/GetWeightByName")
    @FormUrlEncoded
    Observable<JSONObject> getWeight(@Field("") String s);


    /**
     * 根据id查询抽样单详情
     */
    @POST("QuerySamplingJson/QuerySampling")
    @FormUrlEncoded
    Observable<JSONObject> getFormSee(@Field("id") String id);

    /**
     * 订单编号模糊查询
     */
    @POST("QuerySamplingNumber/SamplingNumber")
    @FormUrlEncoded
    Observable<JSONObject> getOrderNumber(@Field("sampling_no") String s);

    /**
     * 状态变更
     */
    @POST("User/UserTypeChange")
    @FormUrlEncoded
    Observable<JSONObject> changeUser(@Field("admin_id") String s,
                                      @Field("user_id") String user_id,
                                      @Field("status_type") String status_type);

    /**
     * 抽样单信息
     */
    @POST("QuerySamplingJson/QuerySampling")
    @FormUrlEncoded
    Observable<JSONObject> getMainList(@Field("sampling_no_name") String s,
                                       @Field("page") String p,
                                       @Field("pagesize") String size,
                                       @Field("user_id") String user_id);


    /**
     * 根据id查询抽样单信息
     */
    @POST("QuerySamplingJson/QuerySampling")
    @FormUrlEncoded
    Observable<JSONObject> getMainList1(@Field("sampling_no_name") String s,
                                        @Field("page") String p,
                                        @Field("pagesize") String size,
                                        @Field("user_id") String user_id,
                                        @Field("id") String id);

    /**
     * 获取电子签名图片
     */
    @POST("PhotoQuery/Picture")
    @FormUrlEncoded
    Observable<JSONObject> getPictureSign(@Field("user_id") String s);

    /**
     * 用户注册
     */
    @POST("User/UserInsert")
    @FormUrlEncoded
    Observable<JSONObject> getSign(@Field("user_name") String user_name,
                                   @Field("user_pwd") String user_pwd,
                                   @Field("user_type") String user_type,
                                   @Field("status_type") String status_type,
                                   @Field("person_name") String person_name,
                                   @Field("person_phone") String person_phone,
                                   @Field("person_address") String person_address,
                                   @Field("person_sex") String person_sex,
                                   @Field("person_number") String person_number,
                                   @Field("person_id_number") String person_id_number,
                                   @Field("leadership") String leadership,
                                   @Field("emergency_contact") String emergency_contact,
                                   @Field("emergency_contact_phone") String p,
                                   @Field("id") String id,
                                   @Field("user_password") String user_password,
                                   @Field("person_jurisdiction") String person_jurisdiction);

    /**
     * 被抽样单位信息
     */
    @POST("QuerySamplingUnitIsPassive/SamplingUnitIsPassive")
    @FormUrlEncoded
    Observable<JSONObject> getByFirm(@Field("customer_name") String s,
                                     @Field("page") String page,
                                     @Field("pagesize") String pagesize);

    /**
     * 获取用户信息
     */
    @POST("User/UserQuery")
    @FormUrlEncoded
    Observable<JSONObject> getUser(@Field("user_name") String s);

    /**
     * 上传抽样单位信息
     */
    @POST("SampleUnit/SampleUnitInsert")
    @FormUrlEncoded
    Observable<JSONObject> addMasterInfo(@Field("unit_name") String s,
                                         @Field("contacts") String contacts,
                                         @Field("address") String address,
                                         @Field("telephone") String telephone,
                                         @Field("fax") String fax,
                                         @Field("zipcode") String zipcode);

    /**
     * 抽样单位信息
     */
    @POST("QuerySamplingUnit/SamplingUnit")
    @FormUrlEncoded
    Observable<JSONObject> getMasterInfo(@Field("unit_name") String s,
                                         @Field("page") String page,
                                         @Field("pagesize") String pagesize);


    /**
     * 获取省份
     */
    @POST("Position/GetCity")
    @FormUrlEncoded
    Observable<JSONObject> getProvice(@Field("") String s);

    /**
     * 获取市
     */
    @POST("Position/GetCity")
    @FormUrlEncoded
    Observable<JSONObject> getCity(@Field("provice_id") String provice_id);

    /**
     * 获取区份
     */
    @POST("Position/GetCity")
    @FormUrlEncoded
    Observable<JSONObject> getDistrict(@Field("city_id") String provice_id);

    /**
     * 获取乡镇
     */
    @POST("Position/GetCity")
    @FormUrlEncoded
    Observable<JSONObject> getCounty(@Field("county_id") String provice_id);

    /**
     * 信息录入-新建被抽样单位
     *
     * @param carsn
     */
    @POST("CustomerInsert.ashx")
    @FormUrlEncoded
    Observable<JSONObject> addCompany(@Field("customer_name") String carsn,
                                      @Field("area_type_id") String area,
                                      @Field("province_id") String province_id,
                                      @Field("city_id") String city_id,
                                      @Field("country_id") String country_id,
                                      @Field("town_id") String town_id,
                                      @Field("address") String address,
                                      @Field("legal_person") String legal_person,
                                      @Field("customer_number_id") String customer_number_id,
                                      @Field("customer_number") String customer_number,
                                      @Field("licence_type_id") String licence_type_id,
                                      @Field("mobile") String telephone,
                                      @Field("fax") String fax,
                                      @Field("contacts") String contacts,
                                      @Field("annual_sales") String annual_sales,
                                      @Field("zipcode") String s,
                                      @Field("licence_num") String l);


    /**
     * 获取副采人
     */
    @POST("User/UserQuery")
    @FormUrlEncoded
    Observable<JSONObject> getSecond(@Field("") String s);

    /**
     * 创建土壤采样项目编号
     */
    @POST("Environment_Soil_Project/ProjectInsert")
    @FormUrlEncoded
    Observable<JSONObject> addSoilProject(@Field("ProName") String title,
                                          @Field("CreateUser") String id,
                                          @Field("ProHeadId") String ProHeadId,
                                          @Field("Status") String Status,
                                          @Field("ProNo") String ProNo);


    /**
     * 增加--水-标签数据
     */
    @POST("Environment_Water_Project_Sub_Pack/Sub_PackInsert")
    @FormUrlEncoded
    Observable<JSONObject> addPackInsert(@Field("HeadProNo") String HeadProNo,
                                         @Field("SampleNo") String SampleNo,
                                         @Field("SamplePackNo") String SamplePackNo,
                                         @Field("DetectionPro") String DetectionPro,
                                         @Field("CreateUser") String CreateUser);

    /**
     * 增加--土壤-标签数据
     */
    @POST("Environment_Soil_Project_Sub_Pack/Sub_PackInsert")
    @FormUrlEncoded
    Observable<JSONObject> addSoilPackInsert(@Field("HeadProNo") String HeadProNo,
                                             @Field("SampleNo") String SampleNo,
                                             @Field("SamplePackNo") String SamplePackNo,
                                             @Field("DetectionPro") String DetectionPro,
                                             @Field("CreateUser") String CreateUser);


    /**
     * 创建水和废水采样项目编号
     */
    @POST("Environment_Water_Project/ProjectInsert")
    @FormUrlEncoded
    Observable<JSONObject> addWaterProject(@Field("ProName") String title, @Field("CreateUser") String id,
                                           @Field("ProHeadId") String ProHeadId, @Field("Status") String Status,
                                           @Field("ProNo") String ProNo);


    /**
     * 创建水和废水表头
     */
    @POST("Environment_Water_Detection_Pro_Title/Detection_Pro_Title_insert")
    @FormUrlEncoded
    Observable<JSONObject> addProjectTitle(@Field("ProNo") String ProNo,
                                           @Field("ProTitleNameOne") String ProTitleNameOne,
                                           @Field("ProTitleNameTwo") String ProTitleNameTwo,
                                           @Field("ProTitleNameThree") String ProTitleNameThree,
                                           @Field("ProTitleNameFour") String ProTitleNameFour,
                                           @Field("ProTitleIDOne") String ProTitleIDOne,
                                           @Field("ProTitleIDTwo") String ProTitleIDTwo,
                                           @Field("ProTitleIDThree") String ProTitleIDThree,
                                           @Field("ProTitleIDFour") String ProTitleIDFour,
                                           @Field("PageNo") String PageNo,
                                           @Field("CreateUser") String CreateUser,
                                           @Field("FixativeContentOne") String FixativeContentOne,
                                           @Field("FixativeContentTwo") String FixativeContentTwo,
                                           @Field("FixativeContentThree") String FixativeContentThree,
                                           @Field("FixativeContentFour") String FixativeContentFour);


    /**
     * 查询土壤颜色
     */
    @POST("Environment_Soil/Environment_Soil_Color")
    @FormUrlEncoded
    Observable<JSONObject> getColor(@Field("") String s);

    /**
     * 查询土壤类型
     */
    @POST("Environment_Soil/Environment_Soil_Type")
    @FormUrlEncoded
    Observable<JSONObject> getSoilType(@Field("") String s);

    /**
     * 查询检测项目
     */
    @POST("Environment_Soil/Environment_Soil_Detection_Pro")
    @FormUrlEncoded
    Observable<JSONObject> getSoil_Detection_Pro(@Field("") String s);

    /**
     * 查询土壤质地
     */
    @POST("Environment_Soil/Environment_Soil_Texture")
    @FormUrlEncoded
    Observable<JSONObject> getSoilTexture(@Field("") String s);

    /**
     * 查询土壤湿度
     */
    @POST("Environment_Soil/Environment_Soil_Humidity")
    @FormUrlEncoded
    Observable<JSONObject> getSoilHumidity(@Field("") String s);

    /**
     * 查询土壤根系含量
     */
    @POST("Environment_Soil/Environment_Soil_Plant")
    @FormUrlEncoded
    Observable<JSONObject> getSoilPlant(@Field("") String s);

    /**
     * 增加土壤采样单项
     */
    @POST("Environment_Soil_Project_Sub/Project_SubInsert")
    @FormUrlEncoded
    Observable<JSONObject> addProjectSubInsert(@Field("category") String s,//重复添加类型
                                               @Field("HeadProNo") String HeadProNo,//项目编号
                                               @Field("SampleDate") String SampleDate,//采样日期
                                               @Field("SampleAddress") String SampleAddress,//采样地点
                                               @Field("LongitudeX") String LongitudeX,//经纬度
                                               @Field("LongitudeY") String LongitudeY,//经纬度
                                               @Field("SampleTime") String SampleTime,//采样时间
                                               @Field("DetectionPro") String DetectionPro,//检测项目id
                                               @Field("SoilType") String SoilType,//土壤类型
                                               @Field("SoilColor") String SoilColor,//土壤颜色
                                               @Field("SoilTexture") String SoilTexture,//土壤质地
                                               @Field("SoilHumidity") String SoilHumidity,//土壤湿度
                                               @Field("PlantRootQuantity") String PlantRootQuantity,//植物根系含量
                                               @Field("SampleQuantity") String SampleQuantity,//采样量
                                               @Field("Sampledepth") String Sampledepth,//采样深度
                                               @Field("SampleLayer") String SampleLayer,//采样层次
                                               @Field("CreateUser") String CreateUser,
                                               @Field("SampleNo_T") String SampleNo_T,
                                               @Field("HeightLongitudeX") String HeightLongitudeX,
                                               @Field("HeightLongitudeY") String HeightLongitudeY,
                                               @Field("DetectionProName") String DetectionProName,//检测项目名称
                                               @Field("SampleNo") String SampleNo//样品编号
    );//检测项目名称

    /**
     * 修改土壤信息
     */
    @POST("Environment_Soil_Update/Soil_Update")
    @FormUrlEncoded
    Observable<JSONObject> updateProjectSubInsert(@Field("Id") String Id,
                                                  @Field("Sub_Id") String Sub_Id,
                                                  @Field("ProNo") String ProNo,//项目编号
                                                  @Field("ProNo_Set") String ProNo_Set,//修改的项目编号
                                                  @Field("ProName") String ProName,//项目名称
                                                  @Field("SampleDate") String SampleDate,//采样日期
                                                  @Field("SampleAddress") String SampleAddress,//采样地点
                                                  @Field("LongitudeX") String LongitudeX,//经纬度X
                                                  @Field("LongitudeY") String LongitudeY,//经纬度Y
                                                  @Field("HeightLongitudeX") String HeightLongitudeX,//高程坐标X
                                                  @Field("HeightLongitudeY") String HeightLongitudeY,//高程坐标Y
                                                  @Field("SampleNo") String SampleNo,//样品编号
                                                  @Field("SampleNo_Set") String SampleNo_Set,//需要修改的样品编号
                                                  @Field("SampleTime") String SampleTime,//采样时间
                                                  @Field("SoilType") String SoilType,//土壤类型
                                                  @Field("SoilColor") String SoilColor,//土壤颜色
                                                  @Field("SoilTexture") String SoilTexture,//土壤质地
                                                  @Field("SoilHumidity") String SoilHumidity,//土壤湿度
                                                  @Field("PlantRootQuantity") String PlantRootQuantity,//植物根系含量
                                                  @Field("SampleQuantity") String SampleQuantity,//采样量
                                                  @Field("Sampledepth") String Sampledepth,//采样深度
                                                  @Field("SampleLayer") String SampleLayer,//采样层次
                                                  @Field("Remark") String Remark//备注

    );//检测项目名称

    /**
     * 查询采样单
     */
    @POST("Environment_Type_Query/Environment_Type_Query")
    @FormUrlEncoded
    Observable<JSONObject> getEnvironmentData(@Field("environment_type") String s,
                                              @Field("Status") String Status,
                                              @Field("UserId") String UserId);

    /**
     * 查询--根据采样单选项目编号查询详细采样单
     */
    @POST("Environment_Soil_Json/Environment_Soil_Json_Query")
    @FormUrlEncoded
    Observable<JSONObject> getSoilJsonQuery(@Field("ProNo") String s, @Field("UserId") String UserId);

    /**
     * 查询--根据采样单选项目编号查询详细采样单
     */
    @POST("Environment_Water_Json/Environment_Water_Json_Query")
    @FormUrlEncoded
    Observable<JSONObject> getWaterJsonQuery(@Field("ProNo") String s, @Field("UserId") String UserId);

    /**
     * 土壤--整体提交
     */
    @POST("Environment_Soil/Environment_Soil_Update")
    @FormUrlEncoded
    Observable<JSONObject> soilCommit(@Field("ProNo") String s, @Field("Remark") String Remark);

    /**
     * 水--整体提交
     */
    @POST("Environment_Water/Environment_Water_Update")
    @FormUrlEncoded
    Observable<JSONObject> waterCommit(@Field("ProNo") String s, @Field("Remark") String Remark);

    /**
     * 水--固定剂提交
     */
    @POST("Environment_Water_Pro_Fixative/FixativeInsert")
    @FormUrlEncoded
    Observable<JSONObject> waterFixativeInsert(@Field("ProNo") String s,
                                               @Field("FixativeContentOne") String FixativeContentOne,
                                               @Field("FixativeContentTwo") String FixativeContentTwo,
                                               @Field("FixativeContentThree") String FixativeContentThree,
                                               @Field("FixativeContentFour") String FixativeContentFour,
                                               @Field("FixativeContentFive") String FixativeContentFive,
                                               @Field("CreateUser") String CreateUser);


    /**
     * 查询--土壤-样品编号地点
     */
    @POST("Environment_Soil/Sample_number_place")
    @FormUrlEncoded
    Observable<JSONObject> getSample_number_place(@Field("HeadProNo") String s);

    /**
     * 查询--水和废水-样品编号地点
     */
    @POST("Environment_Water/Sample_number_place")
    @FormUrlEncoded
    Observable<JSONObject> getWater_number_place(@Field("HeadProNo") String s);

    /**
     * 查询--水和废水-检测项目
     */
    @POST("Environment_Water_Detection_Pro_Title/Detection_Pro_Title_Query")
    @FormUrlEncoded
    Observable<JSONObject> getWaterPro(@Field("") String s);

    /**
     * 查询--水和废水-检测项目表头
     */
    @POST("Environment_Water_Detection_Pro_Title/Sample_number_place")
    @FormUrlEncoded
    Observable<JSONObject> getWaterList(@Field("ProNo") String s);

    /**
     * 查询--水和废水-提交信息
     */
    @POST("Environment_Water_Project_Sub/Project_SubInsert")
    @FormUrlEncoded
    Observable<JSONObject> commitWater(@Field("category") String s,
                                       @Field("SampleNo_Head") String SampleNo_Head,
                                       @Field("SampleNo_B") String SampleNo_B,
                                       @Field("HeadProNo") String HeadProNo,
                                       @Field("SampleDate") String SampleDate,
                                       @Field("SampleTime") String SampleTime,
                                       @Field("SamplingSite") String SamplingSite,
                                       @Field("PointDescription") String PointDescription,
                                       @Field("CreateUser") String CreateUser,
                                       @Field("Status") String Status,
                                       @Field("SampleNo") String SampleNo);


    /**
     * 查询--水和废水-采样量增加
     */
    @POST("Environment_Water_Project_Sub/Project_SamplingInsert")
    @FormUrlEncoded
    Observable<JSONObject> samplingAdd(@Field("Id") String Id,
                                       @Field("PageNo") String PageNo,
                                       @Field("SampleContextOne") String SampleContextOne,
                                       @Field("SampleContextTwo") String SampleContextTwo,
                                       @Field("SampleContextThree") String SampleContextThree,
                                       @Field("SampleContextFour") String SampleContextFour);


    /**
     * 修改食品采样信息
     */
    @POST("ModifyTheLogInsert/ModifyTheLog")
    @FormUrlEncoded
    Observable<JSONObject> updateModifyTheLogInsert(@Field("sampling_id") String sampling_id,//抽样单id
                                                    @Field("user_id") String user_id,//抽样人id
                                                    @Field("sampling_no") String sampling_no,//抽样单编号
                                                    @Field("task_source_supervise") String task_source_supervise,//任务类别，监督抽检
                                                    @Field("task_source_risk") String task_source_risk,//任务类别，风险监测
                                                    @Field("customer_id") String customer_id,//被抽样单位id
                                                    @Field("place_production_id") String place_production_id,//抽样地点(单选):1生产环节,2流通环节 , 3餐饮环节@Field("LongitudeX") String LongitudeX,//经纬度X
                                                    @Field("place_production_detailed_id") String place_production_detailed_id,//抽样地点明细选择
                                                    @Field("place_other_mark") String place_other_mark,//抽样地点其他描述
                                                    @Field("sample_source_id") String sample_source_id,//样品来源id 单选：1加工/自制,2委托生产,3外购,4其他

                                                    @Field("sample_attribute_id") String sample_attribute_id,//样品属性id 外键(单选)：1普通食品,2特殊膳食食品3,食品4,重大活动保障食品

                                                    @Field("sample_type_id") String sample_type_id,//样品类型
                                                    @Field("sample_name") String sample_name,//样品名称
                                                    @Field("sample_trademark") String sample_trademark,//商标
                                                    @Field("sample_date_type_id") String sample_date_type_id,//样品日期类型
                                                    @Field("sample_date") String sample_date,//样品日期
                                                    @Field("sample_model") String sample_model,//样品规格型号
                                                    @Field("sample_number") String sample_number,//样品批号
                                                    @Field("sample_quality_date") String sample_quality_date,//样品保质期
                                                    @Field("sample_technical_doc") String sample_technical_doc,//执行标准，技术文件
                                                    @Field("sample_quality_grade") String sample_quality_grade,//样品质量等级
                                                    @Field("sample_production_license") String sample_production_license,//样品生产许可证编号
                                                    @Field("sample_imported") String sample_imported,//是否进出口
                                                    @Field("sample_count") String sample_count,//抽样数量
                                                    @Field("sample_backups") String sample_backups,//备样数量
                                                    @Field("sample_price") String sample_price,//样品单价
                                                    @Field("sample_form_id") String sample_form_id,//样品形态
                                                    @Field("sample_packing_id") String sample_packing_id,//样品包装
                                                    @Field("production_name") String production_name,//生产者名称
                                                    @Field("production_address") String production_address,//生产者地址
                                                    @Field("production_phone") String production_phone,//生产者联系电话
                                                    @Field("sample_storage_mod1") String sample_storage_mod1,//存储条件
                                                    @Field("sample_storage_mod2") String sample_storage_mod2,//存储条件
                                                    @Field("sample_storage_mod3") String sample_storage_mod3,//存储条件
                                                    @Field("sample_storage_mod4") String sample_storage_mod4,//存储条件
                                                    @Field("sample_storage_mod5") String sample_storage_mod5,//存储条件
                                                    @Field("sample_storage_mod6") String sample_storage_mod6,//存储条件
                                                    @Field("sample_storage_mark") String sample_storage_mark,//存储条件其他
                                                    @Field("sample_packing_type_mod1") String sample_packing_type_mod1,//样品包装
                                                    @Field("sample_packing_type_mod2") String sample_packing_type_mod2,//样品包装
                                                    @Field("sample_packing_type_mod3") String sample_packing_type_mod3,//采样层次
                                                    @Field("sample_packing_type_mod4") String sample_packing_type_mod4,//备注
                                                    @Field("sample_packing_type_mod5") String sample_packing_type_mod5,//采样层次

                                                    @Field("sample_packing_type_mark") String sample_packing_type_mark,//样品包装类型其他
                                                    @Field("sample_mode1") String sample_mode1,//抽样方式
                                                    @Field("sample_mode2") String sample_mode2,//抽样方式
                                                    @Field("sample_unit_id") String sample_unit_id,//抽样单位id
                                                    @Field("marked") String marked,//备注
                                                    @Field("marked2") String marked2,//备注2
                                                    @Field("sub_sampling_person_id") String sub_sampling_person_id,//副采人id
                                                    @Field("sampling_base_batch") String sampling_base_batch,//抽样基数
                                                    @Field("tasksource") String tasksource,//任务来源
                                                    @Field("samplenumberoffoodsafetysampling") String samplenumberoffoodsafetysampling,//NO
                                                    @Field("government_agent") String government_agent,//政府人员
                                                    @Field("price_weight_id") String price_weight_id,//单价
                                                    @Field("base_batch_weight_id") String base_batch_weight_id,//抽样基数单位
                                                    @Field("count_weight_id") String count_weight_id,//抽样数量单位
                                                    @Field("backups_weight_id") String backups_weight_id,//备样数量单位
                                                    @Field("sample_send_off_date") String sample_send_off_date,//寄送样品日期
                                                    @Field("sample_send_address") String sample_send_address//寄送样品地址

    );
}



