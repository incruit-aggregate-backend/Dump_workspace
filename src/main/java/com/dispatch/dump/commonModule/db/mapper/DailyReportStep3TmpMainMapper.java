package com.dispatch.dump.commonModule.db.mapper;

import com.dispatch.dump.commonModule.db.dto.DailyReportStep3TmpMain;

import java.util.List;

public interface DailyReportStep3TmpMainMapper {

    /* FUNCTION ::  등록 */
    int insertDailyReportMain(DailyReportStep3TmpMain dailyReportMain);

    List<DailyReportStep3TmpMain> findJoinDailyReportList(DailyReportStep3TmpMain dailyReportMain);

    /* FUNCTION :: 일보 수정 *//*
    int updateDailyReport(DailyReport dailyReport);

    *//* FUNCTION :: 일보 상세보기 *//*
    DailyReport findDailyReportBySheetID(DailyReport dailyReport);

    /* FUNCTION :: 일보 리스트 조회(전체조건) */
    DailyReportStep3TmpMain findDailyReportMainList(DailyReportStep3TmpMain dailyReportMain);

    //* FUNCTION :: 일보 리스트 조회 (제출처별) *//
/*    List<DailyReport> findDailyReportListByCarSubmit(DailyReport dailyReport);

    int deleteDailyReport(DailyReport dailyReport);*/
}
