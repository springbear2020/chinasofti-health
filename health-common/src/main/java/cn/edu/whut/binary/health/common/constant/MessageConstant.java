package cn.edu.whut.binary.health.common.constant;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 18:33 Saturday
 */
public class MessageConstant {
    public static final String CHECK_ITEM_GROUP_RELATION_EXISTS = "检查项与检查组存在关联，不能删除";
    public static final String CHECK_GROUP_SET_MEAL_RELATION_EXISTS = "检查组与套餐存在关联，不能删除";

    /* ------------------------------------- 检查项 ------------------------------------- */
    public static final String ADD_CHECK_ITEM_SUCCESS = "新增检查项成功";
    public static final String ADD_CHECK_ITEM_FAIL = "新增检查项失败";
    public static final String DELETE_CHECK_ITEM_FAIL = "删除检查项失败";
    public static final String DELETE_CHECK_ITEM_SUCCESS = "删除检查项成功";
    public static final String EDIT_CHECK_ITEM_FAIL = "编辑检查项失败";
    public static final String EDIT_CHECK_ITEM_SUCCESS = "编辑检查项成功";
    public static final String QUERY_CHECK_ITEM_SUCCESS = "查询检查项成功";
    public static final String QUERY_CHECK_ITEM_FAIL = "查询检查项失败";

    /* ------------------------------------- 检查组 ------------------------------------- */
    public static final String ADD_CHECK_GROUP_FAIL = "新增检查组失败";
    public static final String ADD_CHECK_GROUP_SUCCESS = "新增检查组成功";
    public static final String DELETE_CHECK_GROUP_FAIL = "删除检查组失败";
    public static final String DELETE_CHECK_GROUP_SUCCESS = "删除检查组成功";
    public static final String EDIT_CHECK_GROUP_FAIL = "编辑检查组失败";
    public static final String EDIT_CHECK_GROUP_SUCCESS = "编辑检查组成功";
    public static final String QUERY_CHECK_GROUP_SUCCESS = "查询检查组成功";
    public static final String QUERY_CHECK_GROUP_FAIL = "查询检查组失败";
    public static final String QUERY_CHECK_ITEM_OF_GROUP_SUCCESS = "查询检查组对应的检查项成功";
    public static final String QUERY_CHECK_ITEM_OF_GROUP_FAIL = "查询检查组对应的检查项失败";

    /* ------------------------------------- 套餐 ------------------------------------- */
    public static final String ADD_SETMEAL_FAIL = "新增套餐失败";
    public static final String ADD_SETMEAL_SUCCESS = "新增套餐成功";
    public static final String DELETE_SETMEAL_SUCCESS = "删除套餐成功";
    public static final String DELETE_SETMEAL_FAIL = "删除套餐失败";
    public static final String UPDATE_SET_MEAL_SUCCESS = "更新套餐成功";
    public static final String UPDATE_SET_MEAL_FAIL = "更新套餐失败";
    public static final String QUERY_SETMEAL_SUCCESS = "查询套餐数据成功";
    public static final String QUERY_SETMEAL_FAIL = "查询套餐数据失败";
    public static final String QUERY_SETMEAL_LIST_SUCCESS = "查询套餐列表数据成功";
    public static final String QUERY_SETMEAL_LIST_FAIL = "查询套餐列表数据失败";
    public static final String QUERY_CHECK_GROUP_OF_SET_MAIL_FAIL = "查询套餐对应的检查组失败";
    public static final String QUERY_CHECK_GROUP_OF_SET_MAIL_SUCCESS = "查询套餐对应的检查组成功";
    public static final String GET_SETMEAL_COUNT_REPORT_SUCCESS = "获取套餐统计数据成功";
    public static final String GET_SETMEAL_COUNT_REPORT_FAIL = "获取套餐统计数据失败";

    /* ------------------------------------- 文件 ------------------------------------- */
    public static final String UPLOAD_SUCCESS = "文件上传成功";
    public static final String UPLOAD_FAIL = "文件上传失败";

    /* ------------------------------------- 预约 ------------------------------------- */
    public static final String IMPORT_ORDER_SETTING_FAIL = "批量导入预约设置数据失败";
    public static final String IMPORT_ORDER_SETTING_SUCCESS = "批量导入预约设置数据成功";
    public static final String GET_ORDER_SETTING_SUCCESS = "获取预约设置数据成功";
    public static final String GET_ORDER_SETTING_FAIL = "获取预约设置数据失败";
    public static final String ORDER_SETTING_SUCCESS = "预约设置成功";
    public static final String ORDER_SETTING_FAIL = "预约设置失败";
    public static final String QUERY_ORDER_SUCCESS = "查询预约信息成功";
    public static final String QUERY_ORDER_FAIL = "查询预约信息失败";
    public static final String SELECTED_DATE_CANNOT_ORDER = "所选日期不能进行体检预约";
    public static final String ORDER_FULL = "预约人数已满，请重新选择";
    public static final String HAS_ORDERED = "已经完成预约，不能重复预约";
    public static final String ORDER_SUCCESS = "预约成功";
    public static final String ORDER_FAIL = "预约失败";
    public static final String ORDER_SAVE_FAIL = "预约记录保存失败";

    /* ------------------------------------- 验证码 ------------------------------------- */
    public static final String SEND_VALIDATE_CODE_FAIL = "验证码发送失败";
    public static final String SEND_VALIDATE_CODE_SUCCESS = "验证码发送成功，有效时间 2 分钟";
    public static final String VALIDATE_CODE_ERROR = "验证码有误，请重新输入";
    public static final String VALIDATE_CODE_NOT_EXISTS = "验证码不存在，请重新获取";

    /* ------------------------------------- 会员 ------------------------------------- */
    public static final String ADD_MEMBER_FAIL = "新增会员失败";
    public static final String ADD_MEMBER_SUCCESS = "新增会员成功";
    public static final String DELETE_MEMBER_FAIL = "删除会员失败";
    public static final String DELETE_MEMBER_SUCCESS = "删除会员成功";
    public static final String EDIT_MEMBER_FAIL = "编辑会员失败";
    public static final String EDIT_MEMBER_SUCCESS = "编辑会员成功";
    public static final String GET_MEMBER_NUMBER_REPORT_SUCCESS = "获取会员统计数据成功";
    public static final String GET_MEMBER_NUMBER_REPORT_FAIL = "获取会员统计数据失败";

    /* ------------------------------------- 登录 ------------------------------------- */
    public static final String LOGIN_SUCCESS = "登录成功";
    public static final String GET_USERNAME_SUCCESS = "获取当前登录用户名称成功";
    public static final String GET_USERNAME_FAIL = "获取当前登录用户名称失败";
    public static final String GET_MENU_SUCCESS = "获取当前登录用户菜单成功";
    public static final String GET_MENU_FAIL = "获取当前登录用户菜单失败";

    /* ------------------------------------- 运营 ------------------------------------- */
    public static final String GET_BUSINESS_REPORT_SUCCESS = "获取运营统计数据成功";
    public static final String GET_BUSINESS_REPORT_FAIL = "获取运营统计数据失败";
}
