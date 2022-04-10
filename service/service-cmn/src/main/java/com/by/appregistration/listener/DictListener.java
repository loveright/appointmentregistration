package com.by.appregistration.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.by.appregistration.mapper.DictMapper;
import com.by.appregistration.model.cmn.Dict;
import com.by.appregistration.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName DictListener
 * @description: TODO
 * @date 2022/4/1 22:34
 */
public class DictListener extends AnalysisEventListener<DictEeVo> {

    private DictMapper dictMapper;

    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    // 一行一行读取
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);
        dictMapper.insert(dict);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
