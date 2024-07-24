import { DotFilledIcon, DotsVerticalIcon } from "@radix-ui/react-icons";
import { Card } from "../components/ui/card";
import React from "react";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
  Item,
} from "@radix-ui/react-dropdown-menu";
import { Button } from "../components/ui/button";
import { Badge } from "../components/ui/badge";

export const ProjectCard = () => {
  return (
    <Card className="p-5 w-full lg:max-w-3xl">
      <div className="space-y-5">
        <div className="space-y-2">
          <div className="flex justify-between">
            <div className="flex item-center gap-5">
              <h1 className="cursor-pointer font-bold text-lg">
                Create Ecommerce Project
              </h1>
              <DotFilledIcon />
              <p className="text-sm text-gray-300">fulstack</p>
            </div>
            <div>
              <DropdownMenu>
                <DropdownMenuTrigger>
                  <Button className="rounded-full" variant="ghost" size="icon">
                    <DotsVerticalIcon />
                  </Button>
                </DropdownMenuTrigger>
                <DropdownMenuContent>
                  <DropdownMenuItem>Update</DropdownMenuItem>
                  <DropdownMenuItem>Delete</DropdownMenuItem>
                </DropdownMenuContent>
              </DropdownMenu>
            </div>
          </div>
          <p className="text-gray-400">
            Lorem, ipsum dolor sit amet consectetur adipisicing elit.
            Accusantium enim commodi hic
          </p>
        </div>
        <div className="flex flex-wrap gap-2 items-center">
          {[1,1,1,1].map(
            (Item)=> <Badge key={Item} variant="outline">html</Badge>
          )}

        </div>
      </div>
    </Card>
  );
};
