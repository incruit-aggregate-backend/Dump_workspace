package com.dispatch.dump.commonModule.db.mapper;

import com.dispatch.dump.commonModule.db.dto.DailyReportStep3TmpSub;

public interface DailyReportStep3TmpSubMapper {
    
    /* FUNCTION ::  등록 */
    int insertDailyReportSub(DailyReportStep3TmpSub dailyReportStep3TmpSub);

    /*List<DailyReportSub> findDailyReportSubList(DailyReportMain dailyReportMain);*/

    /* FUNCTION :: 일보 수정 *//*
    int updateDailyReport(DailyReport dailyReport);

    *//* FUNCTION :: 일보 상세보기 *//*
    DailyReport findDailyReportBySheetID(DailyReport dailyReport);

    *//* FUNCTION :: 일보 리스트 조회(전체조건) *//*
    List<DailyReport> findDailyReportList(DailyReport dailyReport);

    *//* FUNCTION :: 일보 리스트 조회 (제출처별) *//*
    List<DailyReport> findDailyReportListByCarSubmit(DailyReport dailyReport);

    int deleteDailyReport(DailyReport dailyReport);*/
}
