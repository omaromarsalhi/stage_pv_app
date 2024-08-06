import {
  Card,
  CardHeader,
  CardBody,
  Typography,
  Avatar,
  Tooltip,
  Progress,
} from "@material-tailwind/react";
import { EllipsisVerticalIcon } from "@heroicons/react/24/outline";
import { projectsTableData } from "@/data/index.js";
import "../../../public/css/style.css";
import { generatePv } from "@/loaders/loadData4PV.js";
import { useEffect, useState } from "react";
import { loadPEs } from "@/loaders/laodStudents.js";


export function PvTable() {
  const [projectsTableData, setProjectsTableData] = useState([]);

  useEffect(() => {
    generatePv().then(data => setProjectsTableData(data));
  }, []);

  return (
    <div className="mt-12 mb-8 flex flex-col gap-12">
      <Card>
        <CardBody className="overflow-x-auto overflow-y-auto px-0 pt-0 pb-2" style={{ maxHeight: "400px" }}>
          <table className="w-full max-w-[500px] table-auto ">
            <thead>
            <tr>
              {["UE", "NB_ETC", "MOY/UE", "Modules", "COEF", "MOY_MODULE"].map(
                (el) => (
                  <th
                    key={el}
                    className="border-b border-black py-3 px-5 text-center "
                  >
                    <Typography
                      variant="small"
                      className="text-[15px] font-bold uppercase text-red-700"
                    >
                      {el}
                    </Typography>
                  </th>
                ),
              )}
            </tr>
            </thead>
            <tbody className="border-s border-e border-b border-gray-500  mb-2">
            {projectsTableData.map(
              ({ name, nbr_etc, moy_ue, module, coef, moy_module }, key) => {
                const className = `py-3 px-5 ${
                  key === projectsTableData.length - 1
                    ? "border-b  border-gray-500 text-center"
                    : "border-b  border-gray-500 text-center "
                }`;
                const className2 = "py-0 px-0 border-b border-gray-500 text-center ";

                return (
                  <tr key={name}>
                    <td className={className}>
                      <div className="flex items-center justify-center gap-4 ">
                        <Typography
                          variant="small"
                          color="blue-gray"
                          className="font-bold  "
                        >
                          {name}
                        </Typography>
                      </div>
                    </td>
                    <td className={className}>
                      <div className="flex items-center justify-center gap-4">
                        <Typography
                          variant="small"
                          color="blue-gray"
                          className="font-bold "
                        >
                          {nbr_etc.toFixed(2)}
                        </Typography>
                      </div>
                    </td>
                    <td className={className}>
                      <div className="flex items-center justify-center gap-4">
                        <Typography
                          variant="small"
                          color="blue-gray"
                          className="font-bold"
                        >
                          {moy_ue.toFixed(2)}
                        </Typography>
                      </div>
                    </td>
                    <td className={className2} colSpan={3}>
                      <table className="w-full border-s  max-w-[550px] table-auto">
                        <thead className="invisible ">
                        <tr>
                          {["Modules", "COEF", "MOY_MODULE"].map(
                            (el) => (
                              <th
                                key={el + "omar"}
                                className=" px-5 text-center"
                              >
                                <Typography
                                  variant="small"
                                  className=" hidden-height-important"
                                >
                                  {el}
                                </Typography>
                              </th>

                            ),
                          )}
                        </tr>
                        </thead>
                        <tbody>
                        {module.map(({ module_name, module_coef, module_moy }, key) => {
                          const className = `py-3 px-5 ${
                            key === module.length - 1 ? "" : "border-b border-gray-500"
                          }`;

                          return (
                            <tr key={module_name}>
                              <td className={`${className}  `}>
                                <div className="flex items-center justify-center gap-4">
                                  <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-bold"
                                  >
                                    {module_name}
                                  </Typography>
                                </div>
                              </td>
                              <td className={`${className}  `}>
                                <div className="flex items-center justify-center gap-4">
                                  <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-bold  "
                                  >
                                    {module_coef.toFixed(2)}
                                  </Typography>
                                </div>
                              </td>
                              <td className={`${className}  `}>
                                <div className="flex items-center justify-center gap-4">
                                  <Typography
                                    variant="small"
                                    color="blue-gray"
                                    className="font-bold "
                                  >
                                    {module_moy.toFixed(2)}
                                  </Typography>
                                </div>
                              </td>
                            </tr>
                          );
                        })}

                        {/*{module.map(*/}
                        {/*  ({ module_name, module_coef, module_moy }, key) => {*/}
                        {/*    const className = `py-3 px-5 ${*/}
                        {/*      key === module.length - 1*/}
                        {/*        ? ""*/}
                        {/*        : "border-b border-gray-500 "*/}
                        {/*    }`;*/}

                        {/*    return (*/}
                        {/*      <tr key={module_name}>*/}
                        {/*        <td className={className}>*/}
                        {/*          <div className="flex items-center justify-center gap-4">*/}
                        {/*            <Typography*/}
                        {/*              variant="small"*/}
                        {/*              color="blue-gray"*/}
                        {/*              className="font-bold"*/}
                        {/*            >*/}
                        {/*              {module_name}*/}
                        {/*            </Typography>*/}
                        {/*          </div>*/}
                        {/*        </td>*/}
                        {/*        <td className={className}>*/}
                        {/*          <div className="flex items-center justify-center  gap-4">*/}
                        {/*            <Typography*/}
                        {/*              variant="small"*/}
                        {/*              color="blue-gray"*/}
                        {/*              className="font-bold"*/}
                        {/*            >*/}
                        {/*              {module_coef}*/}
                        {/*            </Typography>*/}
                        {/*          </div>*/}
                        {/*        </td>*/}
                        {/*        <td className={className}>*/}
                        {/*          <div className="flex items-center  justify-center gap-4">*/}
                        {/*            <Typography*/}
                        {/*              variant="small"*/}
                        {/*              color="blue-gray"*/}
                        {/*              className="font-bold"*/}
                        {/*            >*/}
                        {/*              {module_moy}*/}
                        {/*            </Typography>*/}
                        {/*          </div>*/}
                        {/*        </td>*/}
                        {/*      </tr>*/}
                        {/*    );*/}
                        {/*  },*/}
                        {/*)}*/}
                        </tbody>
                      </table>
                    </td>
                  </tr>
                );
              },
            )}
            </tbody>
          </table>
        </CardBody>
      </Card>

      <Card>
        <CardBody className="overflow-x-scroll px-0 pt-0 pb-0">
          <table className="w-full min-w-[640px] table-auto">
            <thead>
            <tr>
              {["RESULTAT", "MOYENNE GENERALE", "ANNEE UNIVEZRSITAIRE"].map(
                (el) => (
                  <th
                    key={el}
                    className="border-b border-black py-3 px-5 text-center "
                  >
                    <Typography
                      variant="small"
                      className="text-[15px] font-bold uppercase text-red-700"
                    >
                      {el}
                    </Typography>
                  </th>
                ),
              )}
            </tr>
            </thead>
            <tbody>
            <tr key="moyenne">
              <td className="border-b border-black text-center py-3 px-5">
                <div className="flex items-center justify-center gap-4 ">
                  <Typography
                    variant="small"
                    color="blue-gray"
                    className="font-bold  "
                  >
                    Admin
                  </Typography>
                </div>
              </td>
              <td className="border-b border-black text-center py-3 px-5">
                <div className="flex items-center justify-center gap-4 ">
                  <Typography
                    variant="small"
                    color="blue-gray"
                    className="font-bold  "
                  >
                    17.05/20
                  </Typography>
                </div>
              </td>
              <td className="border-b border-black text-center py-3 px-5">
                <div className="flex items-center justify-center gap-4 ">
                  <Typography
                    variant="small"
                    color="blue-gray"
                    className="font-bold  "
                  >
                    2024/2025
                  </Typography>
                </div>
              </td>
            </tr>
            </tbody>
          </table>
        </CardBody>
      </Card>
    </div>
  );
}

export default PvTable;
