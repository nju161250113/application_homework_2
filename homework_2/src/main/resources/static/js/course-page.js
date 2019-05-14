
(function () {
  'use strict';
  
  const allCoursesTBody = document.getElementById('all-courses'),
        myCoursesTBody = document.getElementById('my-courses'),
        stuId = getQueryStringArgs().stuId;
  
  function getQueryStringArgs(){
    //去掉开头的问号
    let qs = (location.search.length > 0 ? location.search.substring(1) : ''),
        args = {}, //保存数据对象
        items = qs.length ? qs.split('&') : [], //每一项
        item = null,
        name = null,
        value = null,
        i = 0,
        len = items.length;
    
    for(i=0; i<len; i++){
      item = items[i].split('=');
      name = decodeURIComponent(item[0]);
      value = decodeURIComponent(item[1]);
      
      if(name.length){
        args[name] = value;
      }
    }
    
    return args;
  }
  
  
  function addCourseRow(courseId, courseName, tbody, btnText, onclick, disabled) {
    let row = tbody.insertRow(-1);
    let cell1 = row.insertCell(-1);
    let cell2 = row.insertCell(-1);
    let cell3 = row.insertCell(-1);
    let id = document.createTextNode(courseId);
    let name = document.createTextNode(courseName);
    let btn = document.createElement('button');
    btn.innerText = btnText;
    
    btn.addEventListener('click', onclick, false);

    btn.disabled = disabled;
  
    cell1.appendChild(id);
    cell2.appendChild(name);
    cell3.appendChild(btn);
    
  }
  
  function toggleBtn(tbody, disabled, courseId) {
    let rows = allCoursesTBody.rows;

    for (let row of rows) {
      let td = row.firstChild,
          id = parseInt(td.innerText);

      if (id === courseId) {
        let btn = row.children[2].firstChild;
        btn.disabled = disabled;
        break;
      }
    }
  }
  
  
  function chooseCourse(courseId, courseName) {
    axios.get('/select?stu_id=' + stuId + '&course_id=' + courseId)
        .then(function (response) {
          if (Boolean(response.data)) {
            addCourseRow(courseId, courseName, myCoursesTBody, '退选', removeCourse.bind(this, courseId), false);
  
            toggleBtn(allCoursesTBody, true, courseId);
          } else {
            alert('选课失败');
          }
        })
        .catch(function (error) {
          alert('选课失败');
          console.log(error);
        });
  }
  
  function removeCourse(courseId) {
    axios.get('/cancle?course_id=' + courseId + '&stu_id=' + stuId)
        .then(function (response) {
          if (response.data) {
            // 删除已选课程列表中的这一行
            let rows = myCoursesTBody.rows;

            for (let row of rows) {
              let td = row.firstChild,
                  id = parseInt(td.innerText);
    
              if (id === courseId) {
                row.remove();
                break;
              }
            }
  
            // 恢复所有课程列表中这门课的按钮
            toggleBtn(allCoursesTBody, false, courseId);
          } else {
            alert('退选失败');
          }
        })
        .catch(function (error) {
          alert('退选失败');
          console.log(error);
        });
  }

  axios.get('/home?stu_id=' + stuId)
      .then(function (response) {
        for (let course of response.data) {
          addCourseRow(course.id, course.name, myCoursesTBody, '退选',
              removeCourse.bind(this, course.id), false);
        }
      })
      .catch(function (error) {
        alert('网络错误');
        console.log(error);
      });

  axios.get('/courses?stu_id=' + stuId)
      .then(function (response) {
        let allCourses = response.data;
        for (let course of allCourses) {
          addCourseRow(course.course.id, course.course.name, allCoursesTBody, '选择',
              chooseCourse.bind(this, course.course.id, course.course.name), course.select);
        }
      })
      .catch(function (error) {
        alert('网络错误');
        console.log(error);
      });
  
  
})();