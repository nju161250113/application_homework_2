
(function () {
    'use strict';

    const studentTBody = document.getElementById('student-tbody'),
          courseTBody = document.getElementById('course-tbody'),
          selectTBody = document.getElementById('select-tbody');

    axios.get('/student/getAll')
        .then(function (response) {
            if (response.data != null) {
                for (let stu of response.data) {
                    let row = studentTBody.insertRow(-1);
                    let cell1 = row.insertCell(-1);
                    let cell2 = row.insertCell(-1);
                    let id = document.createTextNode(stu.userId);
                    let name = document.createTextNode(stu.name);

                    cell1.appendChild(id);
                    cell2.appendChild(name);
                }
            }
        })
        .catch(function (error) {
          alert('网络错误');
          console.log(error);
        });

    axios.get('/class/getAll')
        .then(function (response) {
          if (response.data != null) {
              for (let course of response.data) {
                  let row = courseTBody.insertRow(-1);
                  let cell1 = row.insertCell(-1);
                  let cell2 = row.insertCell(-1);
                  let id = document.createTextNode(course.courseId);
                  let name = document.createTextNode(course.name);

                  cell1.appendChild(id);
                  cell2.appendChild(name);
              }
          }

        })
        .catch(function (error) {
          alert('网络错误');
          console.log(error);
        });

    axios.get('/class/getAllSelect')
        .then(function (response) {
            if (response.data != null) {
                for (let detail of response.data) {
                    let row = selectTBody.insertRow(-1);
                    let cell1 = row.insertCell(-1);
                    let cell2 = row.insertCell(-1);
                    let cell3 = row.insertCell(-1);
                    let cell4 = row.insertCell(-1);
                    let sid = document.createTextNode(detail.stuId);
                    let sname = document.createTextNode(detail.stuName);
                    let cid = document.createTextNode(detail.courseId);
                    let cname = document.createTextNode(detail.courseName);

                    cell1.appendChild(sid);
                    cell2.appendChild(sname);
                    cell3.appendChild(cid);
                    cell4.appendChild(cname);
                }
            }

        })
        .catch(function (error) {
            alert('网络错误');
            console.log(error);
        });
})();