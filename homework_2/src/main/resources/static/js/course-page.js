
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
  
  
  function addCourseRow(courseId, courseName, tbody, btnText, onclick) {
    let row = tbody.insertRow(-1);
    let cell1 = row.insertCell(-1);
    let cell2 = row.insertCell(-1);
    let cell3 = row.insertCell(-1);
    let id = document.createTextNode(courseId);
    let name = document.createTextNode(courseName);
    let btn = document.createElement('button');
    btn.innerText = btnText;
    
    btn.addEventListener('click', onclick, false);
  
    cell1.appendChild(id);
    cell2.appendChild(name);
    cell3.appendChild(btn);
    
  }

  function removeCourseRow(courseId, tbody) {
      let rows = tbody.rows;

      for (let row of rows) {
          let td = row.firstChild,
              id = td.innerText;

          if (id === courseId.toString()) {
              row.remove();
              break;
          }
      }
  }

  function chooseCourse(courseId, courseName) {
    axios.get('/class/selectClass/' + stuId + '/' + courseId)
        .then(function (response) {
          if (response.data) {
            // 把课程增加到一选课程列表中
            addCourseRow(courseId, courseName, myCoursesTBody, '退选', removeCourse.bind(this, courseId, courseName));

            // 把课程从其他课程列表中移除
            removeCourseRow(courseId, allCoursesTBody);
          } else {
            alert('选课失败');
          }
        })
        .catch(function (error) {
          alert('选课失败');
          console.log(error);
        });
  }
  
  function removeCourse(courseId, courseName) {
    axios.get('/class/returnClass/' + stuId + '/' + courseId)
        .then(function (response) {
          if (response.data) {
            // 删除已选课程列表中的这一行
            removeCourseRow(courseId, myCoursesTBody);
  
            // 把这门课添加到其他课程列表中
              addCourseRow(courseId, courseName, allCoursesTBody, '选择', chooseCourse.bind(this, courseId, courseName));
          } else {
            alert('退选失败');
          }
        })
        .catch(function (error) {
          alert('退选失败');
          console.log(error);
        });
  }

  axios.get('/class/getMyClass/' + stuId)
      .then(function (response) {
          if (response.data != null) {
              for (let course of response.data) {
                  addCourseRow(course.courseId, course.name, myCoursesTBody, '退选',
                      removeCourse.bind(this, course.courseId, course.name), false);
              }
          }
      })
      .catch(function (error) {
        alert('网络错误');
        console.log(error);
      });

  axios.get('/class/getOtherClass/' + stuId)
      .then(function (response) {
        if (response.data != null) {
            for (let course of response.data) {
                addCourseRow(course.courseId, course.name, allCoursesTBody, '选择',
                    chooseCourse.bind(this, course.courseId, course.name), course.select);
            }
        }

      })
      .catch(function (error) {
        alert('网络错误');
        console.log(error);
      });
  
  
})();