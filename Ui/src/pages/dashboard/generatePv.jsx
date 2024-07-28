import {
  Card,
  CardHeader,
  CardBody,
  Typography,
  Avatar,
  Chip, MenuHandler, IconButton, MenuList, MenuItem, Menu,
} from "@material-tailwind/react";
import { EllipsisVerticalIcon } from "@heroicons/react/24/outline/index.js";
import React, {  useEffect, useState } from "react";
import { request } from "@/helpers/axios_helper.js";
import {
  gradesData,
  handleGradeOnClick,
  handleLevelOnClick,
  levelsData,
  setUpGeneratePvPage,
} from "@/loaders/laodStudents.js";


export function GeneratePv() {
  const [authorsTableData, setAuthorsTableData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  setUpGeneratePvPage(1,"1A1")


  useEffect(() => {
    request(
      "POST",
      "/pv/generate-pv/getStudents",
      {
        level: 1,
        grade: "1A1",
      }).then(
      (response) => {
        setIsLoading(false);
        const formattedData = response.data.map(student => ({
          img: "/img/team-2.jpeg",
          name: student.firstName + " " + student.lastName,
          email: student.email,
          identifier: student.identifier,
          online: true,
          score: "-",
        }));

        setAuthorsTableData(formattedData);

      }).catch(
      (error) => {
        console.log(error);
      },
    );

  }, []);




  if (isLoading) {
    return <div>Loading...</div>;
  }


  return (
    <div className="mt-12 mb-8 flex flex-col gap-12">
      <Card>
        <CardHeader
          variant="gradient"
          color="gray"
          // className="mb-8 p-6"
          floated={false}
          shadow={false}
          className="m-0 flex items-center justify-between p-6"
        >
          <Typography variant="h6" color="white">
            1A / 1A1 / 2024-2025
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
                          <MenuItem onClick={() => handleLevelOnClick({name})}>{name}</MenuItem>
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
                  <MenuList className="max-h-60 overflow-y-auto bg-green-100" >
                    {gradesData.map(
                      ({ name }, key) => {
                        return (
                          <MenuItem onClick={() => handleGradeOnClick({name})}>{name}</MenuItem>
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
              ({ img, name, email, identifier, online, score }, key) => {
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
                        color={online ? "green" : "blue-gray"}
                        value={online ? "online" : "offline"}
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
                        className="text-xs font-semibold text-blue-gray-600"
                      >
                        GeneratePv
                      </Typography>
                    </td>
                  </tr>
                );
              },
            )}
            </tbody>
          </table>
        </CardBody>
      </Card>
    </div>
  );

}

export default GeneratePv;
