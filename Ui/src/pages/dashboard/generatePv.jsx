import {
  Card,
  CardHeader,
  CardBody,
  Typography,
  Avatar,
  Chip, MenuHandler, IconButton, MenuList, MenuItem, Menu,
} from "@material-tailwind/react";
import { EllipsisVerticalIcon } from "@heroicons/react/24/outline/index.js";
import React, { useEffect, useState } from "react";
import {
  loadStudents, loadPEs, loadGrades,
} from "@/loaders/laodStudents.js";
import { useSelector } from "react-redux";
import { setUsernameAndToken } from "@/helpers/refresh_token.js";
import { CiFaceMeh } from "react-icons/ci";
import Popup from "@/pages/dashboard/popup.jsx";


export function GeneratePv() {
  const [authorsTableData, setAuthorsTableData] = useState([]);
  const [levelsData, setLevelsData] = useState();
  const [gradesData, setGradesData] = useState();
  const [level, setLevel] = useState("1A");
  const [grade, setGrade] = useState("1A2");
  const [isLoading, setIsLoading] = useState(true);
  const [isPanEtudeLoadedYet, setIsPanEtudeLoadedYet] = useState(false);
  const [isPopupVisible, setPopupVisible] = useState(false);
  const [studentData, setStudentData] = useState({
    name: "",
    email: "",
    identifier: "",
    grade: "",
    level: "",
    idUser: 0
  });
  const user = useSelector((state) => state.user);


  setUsernameAndToken(user.email);

  useEffect(() => {
    loadPEs().then(data => {
      setLevelsData(data);
      setIsPanEtudeLoadedYet(true);
    });
  }, []);

  useEffect(() => {
    if (isPanEtudeLoadedYet) {
      loadGrades(level).then(data => {
        setGrade((data.length <= 0) ? null : data[0].name);
        setGradesData(data);
      });
    }
  }, [level, isPanEtudeLoadedYet]);

  useEffect(() => {
    if (grade !== null && isPanEtudeLoadedYet) {
      loadStudents(grade).then(students => {
          setAuthorsTableData(students);
          setIsLoading(false);
        },
      );
    } else
      setAuthorsTableData([]);
  }, [grade, isPanEtudeLoadedYet]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  const handleLevelOnClick = (item) => {
    setLevel(item.name);
  };

  const handleGradeOnClick = (item) => {
    setGrade(item.name);
  };

  const showPopup = (name, email, identifier, idUser) => {
    setPopupVisible(true);
  };

  const hidePopup = () => {
    setPopupVisible(false);
  };


  return (
    <div className="mt-12 mb-8 flex flex-col gap-12">
      <Card>
        <CardHeader
          variant="gradient"
          color="gray"
          floated={false}
          shadow={false}
          className="m-0 flex items-center justify-between p-6"
        >
          <Typography variant="h6" color="white">
            {level} / {grade ? grade : "none"} / 2024-2025
          </Typography>
          <Menu placement="left-start">
            <MenuHandler>
              <IconButton size="sm" variant="text" color="white">
                <EllipsisVerticalIcon
                  strokeWidth={3}
                  fill="currenColor"
                  className="h-6 w-6"
                />
              </IconButton>
            </MenuHandler>
            <MenuList>
              <MenuItem>Generate PVs</MenuItem>
              <MenuItem>
                <Menu placement="left-start">
                  <MenuHandler>
                    <p>Change Level</p>
                  </MenuHandler>
                  <MenuList className="max-h-60 overflow-y-auto bg-green-100">
                    {levelsData.map(
                      ({ name }, key) => {
                        return (
                          <MenuItem onClick={() => handleLevelOnClick({ name })}>{name}</MenuItem>
                        );
                      },
                    )}
                  </MenuList>
                </Menu>
              </MenuItem>
              <MenuItem>
                <Menu placement="left-start">
                  <MenuHandler>
                    <p>Change Class</p>
                  </MenuHandler>
                  <MenuList className="max-h-60 overflow-y-auto bg-green-100">
                    {gradesData.map(
                      ({ name }, key) => {
                        return (
                          <MenuItem onClick={() => handleGradeOnClick({ name })}>{name}</MenuItem>
                        );
                      },
                    )}
                  </MenuList>
                </Menu>
              </MenuItem>
            </MenuList>
          </Menu>
        </CardHeader>
        <CardBody className="overflow-x-scroll px-0 pt-0 pb-2">
          <table className="w-full min-w-[640px] table-auto">
            <thead>
            <tr>
              {["Student", "Identifier", "Financial Status", "Score", ""].map((el) => (
                <th
                  key={el}
                  className="border-b border-blue-gray-50 py-3 px-5 text-left "
                >
                  <Typography
                    variant="small"
                    className="text-[11px] font-bold uppercase text-blue-gray-400"
                  >
                    {el}
                  </Typography>
                </th>
              ))}
            </tr>
            </thead>
            <tbody>
            {authorsTableData.map(
              ({ img, idUser, name, email, identifier, online, score }, key) => {
                const className = `py-3 px-5 ${
                  key === authorsTableData.length - 1
                    ? ""
                    : "border-b border-blue-gray-50"
                }`;

                return (
                  <tr key={name}>
                    <td className={className}>
                      <div className="flex items-center gap-4">
                        <Avatar src={img} alt={name} size="sm" variant="rounded" />
                        <div>
                          <Typography
                            variant="small"
                            color="blue-gray"
                            className="font-semibold"
                          >
                            {name}
                          </Typography>
                          <Typography className="text-xs font-normal text-blue-gray-500">
                            {email}
                          </Typography>
                        </div>
                      </div>
                    </td>
                    <td className={className}>
                      <Typography className="text-xs font-semibold text-blue-gray-600 ">
                        {identifier}
                      </Typography>
                    </td>
                    <td className={className}>
                      <Chip
                        variant="gradient"
                        color={online ? "green" : "red"}
                        value={online ? "payee" : "non payee"}
                        className="py-0.5 px-2 text-[11px] font-medium w-fit"
                      />
                    </td>
                    <td className={className}>
                      <Typography className="text-xs font-semibold text-blue-gray-600">
                        {score}
                      </Typography>
                    </td>
                    <td className={className}>
                      <Typography
                        as="a"
                        href="#"
                        className="text-[30px] text-blue-gray-600"
                        onClick={() => {
                          setStudentData({ name, email, identifier,grade, level, idUser });
                          showPopup();
                        }}
                      >
                        <CiFaceMeh />
                      </Typography>
                    </td>
                  </tr>
                );
              },
            )}
            </tbody>
          </table>
        </CardBody>
        <Popup show={isPopupVisible} student={studentData} onClose={hidePopup} />
      </Card>
    </div>
  );

}

export default GeneratePv;
