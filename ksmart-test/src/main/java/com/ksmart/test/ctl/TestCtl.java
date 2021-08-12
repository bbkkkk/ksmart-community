package com.ksmart.test.ctl;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/basic-api/")
@Log4j2
public class TestCtl {

    @GetMapping("/system/getAccountList")
    Object getAccountList(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize) {
       log.debug(page);
       log.debug(pageSize);
        String json="{\"code\":0,\"result\":{\"items\":[{\"id\":\"0\",\"account\":\"Edward\",\"email\":\"i.ipns@vsnn.cn\",\"nickname\":\"侯霞\",\"role\":\"Susan\",\"createTime\":\"1976-11-19 11:19:50\",\"remark\":\"活从儿们来提公示品花无体\",\"status\":\"1\"},{\"id\":\"1\",\"account\":\"Timothy\",\"email\":\"y.zgy@ehod.my\",\"nickname\":\"孟芳\",\"role\":\"Shirley\",\"createTime\":\"1998-05-31 19:06:25\",\"remark\":\"思些你织参什节山清四持国取容算制理自自\",\"status\":\"1\"},{\"id\":\"2\",\"account\":\"Jennifer\",\"email\":\"y.mnihlt@ovjobrglj.al\",\"nickname\":\"方磊\",\"role\":\"Nancy\",\"createTime\":\"2008-05-05 04:11:48\",\"remark\":\"四处属西拉们准给品将\",\"status\":\"1\"},{\"id\":\"3\",\"account\":\"Gary\",\"email\":\"e.sljikbz@qsehgqm.so\",\"nickname\":\"秦涛\",\"role\":\"Deborah\",\"createTime\":\"1971-05-09 01:55:29\",\"remark\":\"重领头本边快造节问极家点车为系铁\",\"status\":\"0\"},{\"id\":\"4\",\"account\":\"Gary\",\"email\":\"r.sttnqyxfy@yffxgbov.pw\",\"nickname\":\"吕伟\",\"role\":\"Brenda\",\"createTime\":\"2013-07-04 16:55:50\",\"remark\":\"面转每人已声参专应业花之只然队四三\",\"status\":\"1\"},{\"id\":\"5\",\"account\":\"Elizabeth\",\"email\":\"n.xdyyifp@ivwpnczy.lb\",\"nickname\":\"郭静\",\"role\":\"Betty\",\"createTime\":\"2011-02-19 14:40:00\",\"remark\":\"确美具江会领着至决院发组\",\"status\":\"1\"},{\"id\":\"6\",\"account\":\"Susan\",\"email\":\"p.mfsbutkh@hwjdnnpu.li\",\"nickname\":\"方军\",\"role\":\"Jennifer\",\"createTime\":\"1970-01-06 10:21:53\",\"remark\":\"周育史收求历领需认力点\",\"status\":\"0\"},{\"id\":\"7\",\"account\":\"Linda\",\"email\":\"x.nejyjkxyx@jrzw.cq\",\"nickname\":\"曾伟\",\"role\":\"Donald\",\"createTime\":\"2016-12-14 00:14:44\",\"remark\":\"目省温性而商发政美她地内七设\",\"status\":\"1\"},{\"id\":\"8\",\"account\":\"Anthony\",\"email\":\"i.bctzxpy@kmdoov.in\",\"nickname\":\"吕磊\",\"role\":\"Michelle\",\"createTime\":\"2010-10-26 04:25:34\",\"remark\":\"厂严受青省必题党示酸解红安按斗根\",\"status\":\"0\"},{\"id\":\"9\",\"account\":\"Shirley\",\"email\":\"w.xemwlf@netkr.ua\",\"nickname\":\"宋敏\",\"role\":\"Cynthia\",\"createTime\":\"2008-03-17 03:50:14\",\"remark\":\"长色几有什命斗查看加领斗作必七数因取\",\"status\":\"1\"}],\"total\":20},\"message\":\"ok\",\"type\":\"success\"}";
        return JSON.toJSON(json);

    }
    @GetMapping("/pms/account/get/{id}")
    Object get(@PathVariable(value = "id") String id) {

        String json="{\"code\":0,\"result\":{\"items\":[{\"id\":\"0\",\"account\":\"Edward\",\"email\":\"i.ipns@vsnn.cn\",\"nickname\":\"侯霞\",\"role\":\"Susan\",\"createTime\":\"1976-11-19 11:19:50\",\"remark\":\"活从儿们来提公示品花无体\",\"status\":\"1\"},{\"id\":\"1\",\"account\":\"Timothy\",\"email\":\"y.zgy@ehod.my\",\"nickname\":\"孟芳\",\"role\":\"Shirley\",\"createTime\":\"1998-05-31 19:06:25\",\"remark\":\"思些你织参什节山清四持国取容算制理自自\",\"status\":\"1\"},{\"id\":\"2\",\"account\":\"Jennifer\",\"email\":\"y.mnihlt@ovjobrglj.al\",\"nickname\":\"方磊\",\"role\":\"Nancy\",\"createTime\":\"2008-05-05 04:11:48\",\"remark\":\"四处属西拉们准给品将\",\"status\":\"1\"},{\"id\":\"3\",\"account\":\"Gary\",\"email\":\"e.sljikbz@qsehgqm.so\",\"nickname\":\"秦涛\",\"role\":\"Deborah\",\"createTime\":\"1971-05-09 01:55:29\",\"remark\":\"重领头本边快造节问极家点车为系铁\",\"status\":\"0\"},{\"id\":\"4\",\"account\":\"Gary\",\"email\":\"r.sttnqyxfy@yffxgbov.pw\",\"nickname\":\"吕伟\",\"role\":\"Brenda\",\"createTime\":\"2013-07-04 16:55:50\",\"remark\":\"面转每人已声参专应业花之只然队四三\",\"status\":\"1\"},{\"id\":\"5\",\"account\":\"Elizabeth\",\"email\":\"n.xdyyifp@ivwpnczy.lb\",\"nickname\":\"郭静\",\"role\":\"Betty\",\"createTime\":\"2011-02-19 14:40:00\",\"remark\":\"确美具江会领着至决院发组\",\"status\":\"1\"},{\"id\":\"6\",\"account\":\"Susan\",\"email\":\"p.mfsbutkh@hwjdnnpu.li\",\"nickname\":\"方军\",\"role\":\"Jennifer\",\"createTime\":\"1970-01-06 10:21:53\",\"remark\":\"周育史收求历领需认力点\",\"status\":\"0\"},{\"id\":\"7\",\"account\":\"Linda\",\"email\":\"x.nejyjkxyx@jrzw.cq\",\"nickname\":\"曾伟\",\"role\":\"Donald\",\"createTime\":\"2016-12-14 00:14:44\",\"remark\":\"目省温性而商发政美她地内七设\",\"status\":\"1\"},{\"id\":\"8\",\"account\":\"Anthony\",\"email\":\"i.bctzxpy@kmdoov.in\",\"nickname\":\"吕磊\",\"role\":\"Michelle\",\"createTime\":\"2010-10-26 04:25:34\",\"remark\":\"厂严受青省必题党示酸解红安按斗根\",\"status\":\"0\"},{\"id\":\"9\",\"account\":\"Shirley\",\"email\":\"w.xemwlf@netkr.ua\",\"nickname\":\"宋敏\",\"role\":\"Cynthia\",\"createTime\":\"2008-03-17 03:50:14\",\"remark\":\"长色几有什命斗查看加领斗作必七数因取\",\"status\":\"1\"}],\"total\":20},\"message\":\"ok\",\"type\":\"success\"}";
        return JSON.toJSON(json);

    }

    @PostMapping("/query")
    Object query(@RequestParam(value = "input") String input) {

        return null;
    }

    @DeleteMapping("/delete")
    Object delete(@RequestParam("id") String id) {

        return null;
    }
}
