<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript"
        src="/resources/js/dailyReport/list.js?jsVerType=20<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyyMMddHHmmss"/>"></script>
<section class="sub-contents-wrap maxwrap">
    <div class="sub-title">
        <h1 class="sub-title__h1">
            <span class="v-mid">주문·배차등록</span>
            <img src="/resources/image/icons/ico_que.png" alt="" class="que-dis-mn"
                 onclick="$.openLayerHelpMsgPopUp(this, 'W04');">
        </h1>

        <ul class="location__ul">
            <li><span class="offscreen">홈</span></li>
            <li>
                <span class="trn">주문·배차등록</span>
            </li>
        </ul>
    </div>

    <form name="pagefrm" method="post">
        <input type="hidden" name="pageNo" value="${paging.pageNo}"/>
        <input type="hidden" name="searchSelectDate" value="${searchData.searchSelectDate}"/>
        <input type="hidden" name="carNo" value="${searchData.carNo}"/>
        <input type="hidden" name="carHost" value="${searchData.carHost}"/>
        <input type="hidden" name="sheetID" value="0"/>
        <input type="hidden" name="searchDetailChk" value="${searchData.searchDetailChk}">
        <input type="hidden" name="sscode" value="${searchData.sscode}">
    </form>

    <form name="searchfrm" method="post">
        <%--        <input type="hidden" name="pageNo" value="${paging.pageNo}"/>--%>
        <%--        <input type="hidden" id="searchDetailChk" name="searchDetailChk" value="${searchData.searchDetailChk}">--%>
        <input type="hidden" id="idx" name="idx" value="">
        <input type="hidden" id="carSubmit" name="carSubmit" value="">
        <div class="search-form">
            <div class="search-form-major" id="dateArea">
                <label>운행기간</label>
                <div class="date-wrap dis-ib dis-b-t">
                    <%--                    <input type="text" class="datepicker wp100" value=""--%>
                    <%--                           name="searchSelectDate" readonly autocomplete="off">--%>
                </div>

                <button type="button" id="advsearch" class="btn btn-details">상세검색 열기 ▼</button>
            </div>

            <%--            <ul class="search-form-details dis-n searchArea">--%>
            <%--            </ul>--%>
        </div>
    </form>

    <div class="btn-area erpSearchBtn">
        <input type="button" class="btn btn-search btn-search__line" value="검색" onClick="$.search()"
               onkeydown="if(event.keyCode == 13) return false;">
    </div>

    <div class="mt30">
        <div class="table-top">
            <p class="total"><span>데이터</span> <span class="cnt default-blue">${totalCount}</span>
                <span>건이 검색되었습니다.</span></p>

            <div class="table-btn">
                <button type="button" class="btn" style="float: left; text-align: center; border: 1px solid #0068b7; background: #0068b7; color: #fff; height: 40px; font-weight: 600; font-size: 14px;" onclick="$.openMngForm LayerPopUp('pop-mnglist');">검색어 설정</button>
                <button type="button" class="btn btn-add" onclick="$.moveForm(0); return false;"
                        onkeydown="if(event.keyCode == 13) return false;">등록
                </button>
            </div>
        </div>

        <div style="width: 100%; overflow-x:auto; overflow-y: hidden;">
            <table class="list-table ">
                <colgroup>
                    <col width="6%">
                    <col width="13%">
                    <col width="20%">
                    <col width="23%">
                    <col width="23%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>No</th>
                    <th>운행일</th>
                    <th>제출처</th>
                    <th>상차지</th>
                    <th>하차지</th>
                    <th>품목</th>
                    <th>대수</th>
                </tr>
                </thead>
                <c:if test="${totalCount == 0}">
                    <tr>
                        <td colspan="6">
                            데이터가 검색되지 않았습니다
                        </td>
                    </tr>
                </c:if>
                <c:set var="trStyle" value=""></c:set>
                <c:set var="trNo" value="1"></c:set>
                <c:set var="trNoTemp" value="1"></c:set>
                <c:forEach items="${list}" var="data" varStatus="status">
                    <tr style="${trStyle}" onclick="$.moveForm(${data.sheetID}, '${data.carSubmit}');">
                        <td>
                                ${status.index + 1}
                        </td>
                        <td>
                                ${data.date}
                        </td>
                        <td>
                                ${data.carSubmit}
                        </td>
                        <td>
                                ${data.fromsite}
                        </td>
                        <td>
                                ${data.tosite}
                        </td>
                        <td>
                                ${data.item}
                        </td>
                        <td>
                                ${data.qty}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <c:if test="${totalCount > 0}">
            <section class="paging">
                <ul class="paging__ul" id="page-div">

                    <li><a style="cursor: pointer;" onclick="$.valuePg(${paging.prevPageNo})"><img
                            src="/resources/image/icons/ico_prev.png" alt="이전"></a></li>

                    <li class="pageNum">
                        <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
                            <c:choose>
                                <c:when test="${i eq paging.pageNo}"><a style="cursor: pointer;"
                                                                        onclick="$.valuePg(${i})"
                                                                        class="active">${i}</a></c:when>
                                <c:otherwise><a style="cursor: pointer;"
                                                onclick="$.valuePg(${i})">${i}</a></c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </li>

                    <li><a style="cursor: pointer;" onclick="$.valuePg(${paging.nextPageNo});"><img
                            src="/resources/image/icons/ico_next.png" alt="다음"></a></li>
                </ul>
            </section>
        </c:if>
    </div>

</section>
<%@ include file="../include/footer.jsp" %>