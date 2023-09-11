package com.dispatch.dump.dailyReportModule.controller;

import com.dispatch.dump.commonModule.db.dto.DailyReport;
import com.dispatch.dump.commonModule.db.dto.DailyReportMain;
import com.dispatch.dump.commonModule.db.dto.DailyReportSub;
import com.dispatch.dump.dailyReportModule.service.DailyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dailyReport")
@RequiredArgsConstructor
public class Step7Controller {

    private final DailyReportService dailyReportService;

    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
    public String step7(Model model, DailyReport dailyReport) {
         dailyReportService.list(model, dailyReport);
        return "/dailyReport/step7/receipts";

    }

//    @RequestMapping(value = "/workspace/ajax/save", method = RequestMethod.POST)
//    @ResponseBody
//    public String save(DailyReportMain dailyReportMain, DailyReportSub dailyReportSub) {
//        return step7Service.save(dailyReportMain, dailyReportSub);
//    }

}
