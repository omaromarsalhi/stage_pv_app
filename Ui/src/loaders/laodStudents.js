import { request } from "@/helpers/axios_helper.js";


export async function loadPEs() {
  return await request(
    "POST",
    "/pv/planetude",
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}

export async function loadGrades(level) {
  return await request(
    "POST",
    "/pv/grades/" + level,
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}


export async function loadStudents(grade) {
  return await request(
    "POST",
    "/pv/generate-pv/getStudents",
    {
      grade: grade,
    }).then(
    (response) => {
      return response.data.map(student => ({
        img: "/img/team-2.jpeg",
        name: student.firstName + " " + student.lastName,
        email: student.email,
        identifier: student.identifier,
        online: true,
        score: "-",
      }));
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}

export const onLevelClicked = (item) => {
  return loadGrades(item.name).then(data => {
    console.log("Grades data:", data);
    return data;
  }).catch(error => {
    console.error("Error loading grades:", error);
  });
};

export const handleGradeOnClick = (item) => {
  console.log("Selected Item:", item);
};



// useEffect(() => {
//   setUpGeneratePvPage(1,"1A1")
//
//   request(
//     "POST",
//     "/pv/generate-pv/getStudents",
//     {
//       level: 1,
//       grade: "1A1",
//     }).then(
//     (response) => {
//       setIsLoading(false);
//       const formattedData = response.data.map(student => ({
//         img: "/img/team-2.jpeg",
//         name: student.firstName + " " + student.lastName,
//         email: student.email,
//         identifier: student.identifier,
//         online: true,
//         score: "-",
//       }));
//
//       setAuthorsTableData(formattedData);
//
//     }).catch(
//     (error) => {
//       console.log(error);
//     },
//   );
//
// }, [authorsTableData]);