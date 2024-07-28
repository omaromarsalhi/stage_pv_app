import {
  Card,
  CardHeader,
  CardBody,
  Typography,
  Avatar,
  Chip, MenuHandler, IconButton, MenuList, MenuItem, Menu,
} from "@material-tailwind/react";
import { authorsTableData, projectsTableData } from "@/data";
import { EllipsisVerticalIcon } from "@heroicons/react/24/outline/index.js";
import React from "react";
import { request } from "@/helpers/axios_helper.js";

export function GeneratePv() {


  request(
    "POST",
    "/generate-pv/getStudents",
    {
      level: 1,
      grade: "1A1",
    }).then(
    (response) => {
      console.log(response.data);

      // const userData = {
      //   identifier: response.data.identifier,
      //   firstname: response.data.firstname,
      //   lastname: response.data.lastname,
      //   email: response.data.email,
      //   role: response.data.role,
      // };


    }).catch(
    (error) => {
      console.log(error);
    },
  );


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
                    <MenuItem>1A</MenuItem>
                    <MenuItem>1I</MenuItem>
                    <MenuItem>2A</MenuItem>
                    <MenuItem>2P</MenuItem>
                    <MenuItem>3A</MenuItem>
                    <MenuItem>3B</MenuItem>
                    <MenuItem>3AI</MenuItem>
                    <MenuItem>4SAE</MenuItem>
                    <MenuItem>4NIDS</MenuItem>
                    <MenuItem>5SAE</MenuItem>
                    <MenuItem>5NIDS</MenuItem>
                  </MenuList>
                </Menu>
              </MenuItem>
              <MenuItem >
                <Menu placement="left-start">
                  <MenuHandler>
                    <p>Change Class</p>
                  </MenuHandler>
                    <MenuList className="max-h-60 overflow-y-auto bg-green-100">
                      <MenuItem>Generate PVs</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
                      <MenuItem>Change Class</MenuItem>
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
                  className="border-b border-blue-gray-50 py-3 px-5 text-left"
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
              ({ img, name, email, job, online, date }, key) => {
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
                      <Typography className="text-xs font-semibold text-blue-gray-600">
                        {job[0]}
                      </Typography>
                      <Typography className="text-xs font-normal text-blue-gray-500">
                        {job[1]}
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
                        {date}
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
