import {
  Dialog,
  DialogContent,
  DialogTrigger,
  DialogHeader,
} from "../../components/ui/dialog";
import React from "react";
import { Button } from "../../components/ui/button";
import CreateProjectForm from "../../Project/CreateProjectForm";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from "@radix-ui/react-dropdown-menu";
import { PersonIcon } from "@radix-ui/react-icons";

const Navbar = () => {
  return (
    <div className="border-b py-4 flex items-center justify-between">
      <div className="flex item-center gap-3">
        <p className="cursor-pointer">Project Management</p>
        <Dialog>
          <DialogTrigger>
            <Button variant="ghost">New Project</Button>
          </DialogTrigger>
          <DialogContent>
            <DialogHeader>Create New Project</DialogHeader>

            <CreateProjectForm />
          </DialogContent>
        </Dialog>
        <Button variant="ghost">Upgrade</Button>
      </div>
      <div className="flex gap-3 items-center">
        <DropdownMenu>
          <DropdownMenuTrigger>
            <Button
              variant="outlinr "
              size="icon"
              className="rounded-full border-2 border-gray-500"
            >
              <PersonIcon />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent>
            <DropdownMenuItem>Logout</DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
        <p>Susheel</p>
      </div>
    </div>
  );
};

export default Navbar;
